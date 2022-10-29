package com.example.moysklad.exceptionhandler.dto;

public class ExceptionResponseDto {
    private final String code;
    private final String message;

    public ExceptionResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
