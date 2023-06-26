package com.mjc.school.service.exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String msg){
        super("ERROR_CODE: 400 ERROR_MESSAGE: " + msg);
    }
}
