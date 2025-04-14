package com.mycompany.restwebapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycompany.restwebapp.dto.ErrorDetails;

/**
 * ExceptionControllerAdvice
 */

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler({NotEnoughMoneyException.class})
    public ResponseEntity<ErrorDetails> exceptinoNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money");

        return ResponseEntity
            .badRequest()
            .body(errorDetails);
    }
}

