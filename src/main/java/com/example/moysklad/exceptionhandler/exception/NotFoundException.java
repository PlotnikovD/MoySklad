package com.example.moysklad.exceptionhandler.exception;

public abstract class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
