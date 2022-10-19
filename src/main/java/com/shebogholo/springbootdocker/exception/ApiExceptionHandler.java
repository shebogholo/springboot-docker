package com.shebogholo.springbootdocker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleException(ApiRequestException e){
        // 1. Create payload
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
                e.getMessage(),
                LocalDateTime.now()
        );
        // 2. Return payload
        return new ResponseEntity<>(apiException, badRequest);
    };
}
