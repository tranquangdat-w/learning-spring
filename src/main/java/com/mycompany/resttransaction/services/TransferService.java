package com.mycompany.resttransaction.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.resttransaction.exception.AccountNotFoundException;
import com.mycompany.resttransaction.exception.NotEnoughMoneyException;
import com.mycompany.resttransaction.model.Account;
import com.mycompany.resttransaction.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
  private final AccountRepository accountRepository;

  @Transactional
  public void transferMoney(long senderId, long receiverId, BigDecimal transferAmount) {
    Account senderAccount = accountRepository.findAccountById(senderId).orElseThrow(() -> new AccountNotFoundException("Sender account not found!"));

    Account receiverAccount = accountRepository.findAccountById(receiverId).orElseThrow(() -> new AccountNotFoundException("Reciver account not found!"));

    if (senderAccount.getAmount().compareTo(transferAmount) < 0) {
      throw new NotEnoughMoneyException(String.format("User with id %d do not have enough money to transfer %.2f$ to user with id %d", senderId, transferAmount,receiverId)); 
    }

    BigDecimal senderNewAmount = senderAccount.getAmount().subtract(transferAmount);

    BigDecimal receiverNewAmount = receiverAccount.getAmount().add(transferAmount);

    accountRepository.setAmount(senderId, senderNewAmount);
    accountRepository.setAmount(receiverId, receiverNewAmount);
  } 
}
