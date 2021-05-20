package com.samrat.i18n.app.exception;

public class MyCustomException extends RuntimeException {

    private Object[] args;

    public MyCustomException() {
    }

    public MyCustomException(String message) {
        super(message);
    }

    public MyCustomException(String message, Object[] args) {
        super(message);
        this.args = args;
    }

    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
