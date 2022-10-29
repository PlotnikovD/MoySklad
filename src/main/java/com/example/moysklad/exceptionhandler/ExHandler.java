package com.example.moysklad.exceptionhandler;

import com.example.moysklad.exceptionhandler.dto.ExceptionResponseDto;
import com.example.moysklad.exceptionhandler.exception.DocumentNotFoundException;
import com.example.moysklad.exceptionhandler.exception.ProductNotFoundException;
import com.example.moysklad.exceptionhandler.exception.StorageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(ProductNotFoundException e) {
        ExceptionResponseDto response = new ExceptionResponseDto("PRODUCT_NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StorageNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(StorageNotFoundException e) {
        ExceptionResponseDto response = new ExceptionResponseDto("STORAGE_NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public  ResponseEntity<ExceptionResponseDto> handleException(DocumentNotFoundException e) {
        ExceptionResponseDto response = new ExceptionResponseDto("DOCUMENT_NOT_FOUND", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}



