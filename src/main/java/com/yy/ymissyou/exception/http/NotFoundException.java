package com.yy.ymissyou.exception.http;

/**
 * 自定义：未找到异常
 * @Date: 2020/12/24 00:58
 * @Description:
 */
public class NotFoundException extends HttpException {

    public NotFoundException(Integer code) {
        this.code = code;
        this.httpStatusCode = 404;
    }
}
