package com.mycompany.resttransaction.controllers;

import java.util.List;

import com.mycompany.resttransaction.dto.request.TransferRequest;
import com.mycompany.resttransaction.model.Account;
import com.mycompany.resttransaction.services.AccountService;
import com.mycompany.resttransaction.services.TransferService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@AllArgsConstructor
@Tag(name = "Sample API", description = "API for account")
public class AccountControler {
  private final TransferService transferService;
  private final AccountService accountService;

  @PostMapping("/transfer")
  @Operation()
  public void transferAmount(
      @RequestBody TransferRequest transferRequest) {
    transferService.transferMoney(transferRequest.getSenderId(), transferRequest.getReceiverId(),
        transferRequest.getTransferAmount());
  }

  @GetMapping("/accounts")
  @Operation()
  public List<Account> findAllAccounts() {
    return accountService.findAllAccounts();
  }
}
