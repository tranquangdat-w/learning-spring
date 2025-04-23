package com.mycompany.resttransaction.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycompany.resttransaction.model.Account;
import com.mycompany.resttransaction.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {
  private final AccountRepository accountRepository;

  public List<Account> findAllAccounts() {
    return accountRepository.findAllAccounts(); 
  }
}
