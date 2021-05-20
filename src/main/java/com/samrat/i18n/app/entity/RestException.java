package com.samrat.i18n.app.entity;

public class RestException {

    private String message;

    public RestException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
