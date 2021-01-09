package com.yy.ymissyou.core;

import com.yy.ymissyou.core.configuration.ExceptionCodeConfiguration;
import com.yy.ymissyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @Date: 2020/12/23 23:59:00
 * @Description: 全局异常捕获处理；可以看作是专门用来处理异常的一个Controller类
 */
@ControllerAdvice // 标明该类是一个统一的异常处理类
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;

    /**
     * 未知异常的处理方法：返还给前端一个unifyResponse对象，这个对象包含了错误码以及错误信息
     */
    @ExceptionHandler(value = Exception.class) // 该注解标注在某个方法中，专门用来处理某个具体类型的异常，value值：异常的类类型
    @ResponseBody // @ExceptionHandler：标注了该注解的方法的返回值和@RequestMapping方法返回值一样，@ResponseBody：表示返回一个JSON数据
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //改变返回的http状态码
    public UnifyResponse handleException(HttpServletRequest request, Exception e) {
        String requestURL = request.getContextPath() + request.getRequestURI();
        String method = request.getMethod();
        UnifyResponse unifyResponse = new UnifyResponse(9999, "服务器异常", method + " " + requestURL);
        return unifyResponse;
    }

    /**
     * 已知异常处理方法
     */
    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity handleHttpException(HttpServletRequest request, HttpException e) {
        String requestURL = request.getContextPath() + request.getRequestURI();
        String method = request.getMethod();

        UnifyResponse unifyResponse = new UnifyResponse(e.getCode(), exceptionCodeConfiguration.getMessage(e.getCode()), method + " " + requestURL);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpStatus status = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> responseEntity = new ResponseEntity<>(unifyResponse, httpHeaders, status);
        return responseEntity;
    }

    /**
     * 处理URL中的参数校验异常，例如BannerController中@GetMapping(value = "/test/{id}")中的id加上校验注解：
     *
     * @Range(min = 1,max = 10,message = "URL中的id值需要在1和10之间")，抛出异常后会由子方法进行处理
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintViolationException(HttpServletRequest request, ConstraintViolationException e) {
        String requestURL = request.getContextPath() + request.getRequestURI();
        String method = request.getMethod();

        String message = e.getMessage(); // 如果一个方法中的多个参数校验失败，会将错误的消息一起封装到e.getMessage()中
        return new UnifyResponse(10002, message, method + " " + requestURL);
    }

    /**
     * 处理Bean校验异常，可以处理一些JSR303校验异常，和自定义的异常
     *
     * @param request：请求路径+请求方法的字符串
     * @param e                     异常类型
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class) // 标明该方法需要处理什么样的异常
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 改变程序执行完成之后返回的状态码
    public UnifyResponse handleBeanValidation(HttpServletRequest request, MethodArgumentNotValidException e) {
        String requestURL = request.getRequestURI();
        String method = request.getMethod();

        // 获取所有的参数校验异常消息；
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        String message = formatAllErrorMessages(allErrors);
        UnifyResponse response = new UnifyResponse(10001, message, method + " " + requestURL);

        return response;
    }

    /**
     * 获取errors中的message并封装成一个String
     *
     * @param errors 错误信息
     */
    public String formatAllErrorMessages(List<ObjectError> errors) {
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error -> errorMsg.append(error.getDefaultMessage()).append(";"));
        return errorMsg.toString();
    }
}
