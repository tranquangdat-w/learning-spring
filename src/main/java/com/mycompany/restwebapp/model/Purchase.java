package com.mycompany.restwebapp.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Purchase {
  private int id;
  private String product;
  private BigDecimal price;
}
