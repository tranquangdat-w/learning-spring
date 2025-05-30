package com.mycompany.resttransaction.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotEnoughMoneyException extends RuntimeException {
  private final String message;
}
