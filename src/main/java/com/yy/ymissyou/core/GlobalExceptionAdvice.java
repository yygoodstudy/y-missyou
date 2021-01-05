package com.yy.ymissyou.core;

import com.yy.ymissyou.core.configuration.ExceptionCodeConfiguration;
import com.yy.ymissyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2020/12/23 23:59
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;

    /**
     * 未知异常的处理方法：返还给前端一个unifyResponse对象，这个对象包含了错误码以及错误信息
     *
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //设置http状态码
    public UnifyResponse handleException(HttpServletRequest request, Exception e) {
        String requestURL = request.getContextPath() + request.getRequestURI();
        String method = request.getMethod();
        //System.out.println("hello world!!!");
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
        //System.out.println("into handleHttpException!!");
    }
}
