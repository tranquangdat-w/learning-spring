package com.mycompany.resttransaction.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.mycompany.resttransaction.dto.TransferRequest;
import com.mycompany.resttransaction.model.Account;
import com.mycompany.resttransaction.services.AccountService;
import com.mycompany.resttransaction.services.TransferService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@AllArgsConstructor
public class AccountControler {
  private final TransferService transferService;
  private final AccountService accountService;

  @PostMapping("/transfer")
  public void transferAmount(
    @RequestBody TransferRequest transferRequest
  ) {
    transferService.transferMoney(transferRequest.getSenderId(), transferRequest.getReceiverId(), transferRequest.getTransferAmount()); 
  }

  @GetMapping("/accounts")
  public List<Account> findAllAccounts(@RequestParam String param) {
    return accountService.findAllAccounts();
  }
}
