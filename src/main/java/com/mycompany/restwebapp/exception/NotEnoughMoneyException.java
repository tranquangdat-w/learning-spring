package com.mycompany.restwebapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * NotEnoughMoneyException
 */

@AllArgsConstructor
@Getter
public class NotEnoughMoneyException extends RuntimeException {
  private final String message;
}
