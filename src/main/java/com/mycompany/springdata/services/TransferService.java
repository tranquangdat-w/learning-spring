package com.mycompany.springdata.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.springdata.model.Account;
import com.mycompany.springdata.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransferService {
  private final AccountRepository accountRepository;

  @Transactional
  public void transferMoney(
      long senderId,
      long receiverId,
      BigDecimal exchangeAmount) {
    Account senderAccount = accountRepository.findOneAccountById(senderId);

    Account receiverAccount = accountRepository.findOneAccountById(receiverId);

    BigDecimal newSenderAccountAmount = senderAccount.getAmount().subtract(exchangeAmount);
    BigDecimal newReceiverAccountAmount = receiverAccount.getAmount().add(exchangeAmount);

    accountRepository.changeAmount(senderId, newSenderAccountAmount);
    accountRepository.changeAmount(receiverId, newReceiverAccountAmount);
  }
}
