package com.fitlife.app.exceptions.appException;

public class BadRequestException extends Throwable {
    public BadRequestException(String message) {
        super(message);
    }
}