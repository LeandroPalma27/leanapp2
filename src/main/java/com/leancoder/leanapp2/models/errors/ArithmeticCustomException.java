package com.leancoder.leanapp2.models.errors;

import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public class ArithmeticCustomException {
    
    private String message;
    private String error;
    private int status;
    private String date;

    public ArithmeticCustomException() {
    }

    public ArithmeticCustomException(String message, String error, int status, String date) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
