package com.yoedi.libraryapi.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        return ResponseHandler.generateResponse(ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                null);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity entityNotFound(EntityNotFoundException ex) {
        return ResponseHandler.generateResponse(ex.getMessage(),
                HttpStatus.NOT_FOUND,
                null);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity generalException(Exception ex) {
        return ResponseHandler.generateResponse(ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                null);
    }
}
