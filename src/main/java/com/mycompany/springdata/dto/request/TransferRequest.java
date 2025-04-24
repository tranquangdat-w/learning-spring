package com.mycompany.springdata.dto.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransferRequest {
  private long senderId;
  private long receiverId;
  private BigDecimal transferAmount;
}
