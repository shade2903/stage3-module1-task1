package com.mjc.school.service.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg){
        super("ERROR_CODE: 404 ERROR_MESSAGE: " + msg);
    }
}
