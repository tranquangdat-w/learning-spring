package com.mycompany.springdata.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.resttransaction.exception.AccountNotFoundException;
import com.mycompany.resttransaction.exception.NotEnoughMoneyException;
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
    Account senderAccount = accountRepository.findOneAccountById(senderId).orElseThrow(() -> new AccountNotFoundException(String.format("Not found user with id %d", senderId)));

    Account receiverAccount = accountRepository.findOneAccountById(receiverId).orElseThrow(() -> new AccountNotFoundException(String.format("Not found user with id %d", receiverId)));

    if (senderAccount.getAmount().compareTo(exchangeAmount) < 0) {
      throw new NotEnoughMoneyException(String.format("User wiht id %d do not have enough money to transfer %.2f$", senderId, exchangeAmount));
    }

    BigDecimal newSenderAccountAmount = senderAccount.getAmount().subtract(exchangeAmount);
    BigDecimal newReceiverAccountAmount = receiverAccount.getAmount().add(exchangeAmount);

    accountRepository.changeAmount(senderId, newSenderAccountAmount);
    accountRepository.changeAmount(receiverId, newReceiverAccountAmount);
  }

  public List<Account> findAllAccounts() {
    return accountRepository.findAllAccounts();
  }

  public List<Account> findAccountsByName(String name) {
    return accountRepository.findAccountsByName(name);
  }
}
