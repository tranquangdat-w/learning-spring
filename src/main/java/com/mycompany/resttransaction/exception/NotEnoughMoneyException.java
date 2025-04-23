package com.mycompany.resttransaction.exception;

import lombok.Getter;

@Getter
public class NotEnoughMoneyException extends RuntimeException {
  private final String message = "You do not have enough money to perform this action!";
}
