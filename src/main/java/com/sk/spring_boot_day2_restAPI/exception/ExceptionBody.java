package com.sk.spring_boot_day2_restAPI.exception;

import java.time.LocalDateTime;

public class ExceptionBody {
    private String message;
    private LocalDateTime timestamp;

    public ExceptionBody() {
    }

    public ExceptionBody(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ExceptionBody{" +
                "message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
