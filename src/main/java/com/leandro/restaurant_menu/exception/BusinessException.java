package com.leandro.restaurant_menu.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String field;
    private final String errorCode;

    public BusinessException(String message) {
        super(message);
        this.field = null;
        this.errorCode = "BUSINESS_ERROR";
    }

    public BusinessException(String field, String message) {
        super(message);
        this.field = field;
        this.errorCode = "FIELD_ERROR";
    }

    public BusinessException(String field, String message, String errorCode) {
        super(message);
        this.field = field;
        this.errorCode = errorCode;
    }
}

