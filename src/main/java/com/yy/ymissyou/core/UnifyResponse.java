package com.yy.ymissyou.core;

/**
 * @Date: 2020/12/26 23:21
 * @Description: 封装了需要返回给前端页面的异常信息
 */
public class UnifyResponse {

    private Integer code;
    private String message;
    private String request;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public UnifyResponse(Integer code, String message, String request) {
        this.code = code;
        this.message = message;
        this.request = request;
    }
}
