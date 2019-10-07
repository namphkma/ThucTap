package com.thuctap.api.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ExeptionResponse implements Serializable {
    private String message;
    private int code;

    public ExeptionResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ExeptionResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
