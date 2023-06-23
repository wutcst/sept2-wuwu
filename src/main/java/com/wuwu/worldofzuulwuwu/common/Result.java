package com.wuwu.worldofzuulwuwu.common;

/**
 * @author:wangyuze
 * @create: 2023-06-22 17:36
 * @Description: 结果类
 */

public class Result {
    private Integer code;
    private String message;
    private String data;

    public Result(Integer code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
