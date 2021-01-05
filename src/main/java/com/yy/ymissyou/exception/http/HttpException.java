package com.yy.ymissyou.exception.http;

/**
 * @Date: 2020/12/24 00:50
 * @Description:
 */
 public class HttpException extends RuntimeException{
    protected Integer code;
    protected Integer httpStatusCode = 500;

    public Integer getCode() {
        return code;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
