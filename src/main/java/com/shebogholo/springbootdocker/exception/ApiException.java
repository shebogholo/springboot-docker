package com.shebogholo.springbootdocker.exception;

import java.time.LocalDateTime;


public class ApiException {
    private final String message;
    private final LocalDateTime timestamp;

    public ApiException(String message,LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
