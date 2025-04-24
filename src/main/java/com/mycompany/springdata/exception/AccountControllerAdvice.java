package com.mycompany.springdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mycompany.resttransaction.exception.AccountNotFoundException;

@RestControllerAdvice
public class AccountControllerAdvice {
  @ExceptionHandler({ AccountNotFoundException.class })
  public ResponseEntity<AccountNotFoundException> handleAccountNotFoundException(AccountNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex);
  }
}

