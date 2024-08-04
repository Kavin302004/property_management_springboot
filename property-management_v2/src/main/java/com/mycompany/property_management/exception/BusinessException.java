package com.mycompany.property_management.exception;
//RuntimeException need not be handled explicitly in test
public class BusinessException extends RuntimeException {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public BusinessException() {

    }

    public BusinessException(String message) {
        this.msg=message;
    }
}
