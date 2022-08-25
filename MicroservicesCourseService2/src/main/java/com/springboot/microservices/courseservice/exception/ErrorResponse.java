package com.springboot.microservices.courseservice.exception;

import java.time.LocalDateTime;

public class ErrorResponse
{
    private String message;
    private int statusCode;
    private LocalDateTime errorDateTime;

    public ErrorResponse(){}

    public ErrorResponse(String message, int statusCode, LocalDateTime errorDateTime) {
        this.message = message;
        this.statusCode = statusCode;
        this.errorDateTime = errorDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getErrorDateTime() {
        return errorDateTime;
    }

    public void setErrorDateTime(LocalDateTime errorDateTime) {
        this.errorDateTime = errorDateTime;
    }
}
