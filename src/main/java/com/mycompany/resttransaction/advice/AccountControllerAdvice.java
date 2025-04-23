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
  public ResponseEntity<ErrorDetails> handleNotEnoughMoneyException() {
    ErrorDetails notEnoughMoneyException = new ErrorDetails("You do not have enough money to perform this action!");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(notEnoughMoneyException);
  }

  @ExceptionHandler({ AccountNotFoundException.class })
  public ResponseEntity<ErrorDetails> handleAccountNotFoundException() {
    ErrorDetails accountNotFoundError = new ErrorDetails("This account not found!");

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountNotFoundError);
  }
}
