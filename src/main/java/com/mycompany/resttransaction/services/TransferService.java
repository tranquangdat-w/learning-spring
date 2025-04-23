package com.mycompany.resttransaction.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mycompany.resttransaction.model.Account;
import com.mycompany.resttransaction.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
  private final AccountRepository accountRepository;

  public void transferMoney(long senderId, long receiverId, BigDecimal transferAmount) {
    Account senderAccount = accountRepository.findAccountById(senderId);

    Account receiverAccount = accountRepository.findAccountById(senderId);

    BigDecimal senderNewAmount = senderAccount.getAmount().subtract(transferAmount);

    if (senderNewAmount.compareTo(new BigDecimal(0)) < 0) {
    }
    BigDecimal receiverNewAmount = receiverAccount.getAmount().add(transferAmount);
  } 
}
