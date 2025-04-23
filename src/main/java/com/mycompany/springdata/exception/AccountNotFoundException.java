package com.mycompany.springdata.exception;

import lombok.Getter;

@Getter
public class AccountNotFoundException extends RuntimeException {
  private final String message = "Not found account";
}
