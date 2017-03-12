package com.testsmirk.model;

/**
 * Created by Smirk on 2017/3/12.
 */
public class ErrorModel {
    private String message = "异常";
    private int code;

    public ErrorModel(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ErrorModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
