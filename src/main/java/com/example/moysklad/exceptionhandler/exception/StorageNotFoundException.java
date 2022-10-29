package com.example.moysklad.exceptionhandler.exception;

public class StorageNotFoundException extends NotFoundException{
    public StorageNotFoundException(String message){
        super(message);
    }
}
