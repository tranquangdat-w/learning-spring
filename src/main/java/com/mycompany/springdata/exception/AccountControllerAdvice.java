package com.mycompany.springdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycompany.springdata.exception.NotEnoughMoneyException;

@RestControllerAdvice
public class AccountControllerAdvice {
  @ExceptionHandler({ AccountNotFoundException.class })
  public ResponseEntity<ErrorDetails> handleAccountNotFoundException(AccountNotFoundException ex) {
    ErrorDetails notFoundException = new ErrorDetails();
    notFoundException.setMessage(ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException);
  }

  @ExceptionHandler({ NotEnoughMoneyException.class })
  public ResponseEntity<ErrorDetails> handleNotEnoughMoneyException(NotEnoughMoneyException ex) {
    ErrorDetails notEnoughMoneyException = new ErrorDetails();
    notEnoughMoneyException.setMessage(ex.getMessage());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(notEnoughMoneyException);
  }
}
