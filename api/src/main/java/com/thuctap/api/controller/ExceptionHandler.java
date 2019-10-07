package com.thuctap.api.controller;

import com.thuctap.api.exception.BadRequestException;
import com.thuctap.api.exception.ExeptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ExeptionResponse> handlerBadRequestExceoption(BadRequestException e){
        ExeptionResponse response = new ExeptionResponse(e.getMessage(),e.getCode().value());
        return new ResponseEntity<ExeptionResponse>(response,HttpStatus.BAD_REQUEST);
    }
}
