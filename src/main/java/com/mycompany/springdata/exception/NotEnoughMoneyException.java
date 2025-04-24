package com.mycompany.springdata.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotEnoughMoneyException extends RuntimeException {
  private String message;
}
