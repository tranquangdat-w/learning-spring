package com.mycompany.resttransaction.dto.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {
  private long senderId; 
  private long receiverId;
  private BigDecimal transferAmount;
}
