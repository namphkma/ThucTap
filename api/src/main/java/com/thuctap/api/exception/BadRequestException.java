package com.thuctap.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {

    private String message;

    private HttpStatus code;

    public BadRequestException(String message) {
        this.message = message;
        this.code = HttpStatus.BAD_REQUEST;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
