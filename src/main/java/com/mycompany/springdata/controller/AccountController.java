package com.mycompany.springdata.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springdata.dto.request.TransferRequest;
import com.mycompany.springdata.model.Account;
import com.mycompany.springdata.services.TransferService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@Tag(name = "Api for account", description = "This contain api for wallet electric!")
public class AccountController {
  private final TransferService transferService;

  @GetMapping("/accounts")
  @Operation
  public List<Account> findAllAccounts(@RequestParam(required = false) String name) {
    if (name == null) {
      return transferService.findAllAccounts();
    } else {
      return transferService.findAccountsByName(name);
    }
  }

  @PostMapping("/transfer")
  @Operation
  public void transferMoney(
      @RequestBody TransferRequest transferRequest) {
    transferService.transferMoney(transferRequest.getSenderId(), transferRequest.getReceiverId(),
        transferRequest.getTransferAmount());
  }
}
