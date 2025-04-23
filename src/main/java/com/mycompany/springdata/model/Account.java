package com.mycompany.springdata.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
  @Id
  private long id;  
  private String name;
  private BigDecimal amount;
}
