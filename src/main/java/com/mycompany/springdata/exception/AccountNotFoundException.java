package com.mycompany.springdata.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountNotFoundException extends RuntimeException {
  private final String message;
}
