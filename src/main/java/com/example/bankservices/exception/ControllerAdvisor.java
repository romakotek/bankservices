package com.example.bankservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoBankAccountException.class)
    protected ResponseEntity<Object> handleError(RuntimeException ex) {
        String body = "Invalid Bank Account id";
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
