package com.mycompany.resttransaction.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

  private long id; 
  private String username;
  private BigDecimal amount; 
}
