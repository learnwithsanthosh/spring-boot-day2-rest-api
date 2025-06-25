package com.sk.spring_boot_day2_restAPI.repsonseAPI;

import java.time.LocalDateTime;

public class APIResponse <T> {
    private String status;          // e.g., "success" or "error"
    private String message;         // custom message for response
    private T data;                 // your actual payload (DTO, list, etc.)
    private LocalDateTime timestamp; // when response was generated

    public APIResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public APIResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public static <T> APIResponse<T> success(T data) {
        return new APIResponse<>("success","Done", data);
    }

    public static <T> APIResponse<T> delete(T data) {
        return new APIResponse<>("Deleted successfully","Done", data);
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}
