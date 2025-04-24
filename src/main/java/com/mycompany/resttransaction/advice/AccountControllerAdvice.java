package com.mycompany.resttransaction.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycompany.resttransaction.dto.ErrorDetails;
import com.mycompany.resttransaction.exception.AccountNotFoundException;
import com.mycompany.resttransaction.exception.NotEnoughMoneyException;

@RestControllerAdvice
public class AccountControllerAdvice {
  @ExceptionHandler({ NotEnoughMoneyException.class })
  public ResponseEntity<ErrorDetails> handleNotEnoughMoneyException(NotEnoughMoneyException ex) {
    ErrorDetails notEnoughMoneyException = new ErrorDetails(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(notEnoughMoneyException);
  }

  @ExceptionHandler({ AccountNotFoundException.class })
  public ResponseEntity<ErrorDetails> handleAccountNotFoundException(AccountNotFoundException ex) {
    ErrorDetails accountNotFoundError = new ErrorDetails(ex.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountNotFoundError);
  }
}
