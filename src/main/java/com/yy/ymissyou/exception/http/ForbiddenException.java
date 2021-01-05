package com.yy.ymissyou.exception.http;

/**
 * @Date: 2020/12/24 01:00
 * @Description:
 */
public class ForbiddenException extends HttpException{

    public ForbiddenException(Integer code){
        this.code = code;
        this.httpStatusCode = 403; // 被禁用
    }
}
