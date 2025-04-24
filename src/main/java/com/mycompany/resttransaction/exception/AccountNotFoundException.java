package com.mycompany.resttransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountNotFoundException extends RuntimeException {
  private String message;
}

