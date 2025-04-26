package com.mycompany.app;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;


import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mycompany.springdata.exception.AccountNotFoundException;
import com.mycompany.springdata.exception.NotEnoughMoneyException;
import com.mycompany.springdata.model.Account;
import com.mycompany.springdata.repository.AccountRepository;
import com.mycompany.springdata.services.TransferService;

@ExtendWith(MockitoExtension.class)
public class TransferServiceUnitTests {

  @Mock
  private AccountRepository accountRepository;

  @InjectMocks
  private TransferService transferService; 

  @Test
  public void moneyTransferHappyFlow() {
    Account senderAccount = new Account(1L, "dat 1", new BigDecimal(1000));

    Account receiverAccount = new Account(2L, "dat 2", new BigDecimal(1000));

    given(accountRepository.findOneAccountById(senderAccount.getId())).willReturn(Optional.of(senderAccount));
    given(accountRepository.findOneAccountById(receiverAccount.getId())).willReturn(Optional.of(receiverAccount));

    transferService.transferMoney(senderAccount.getId(), receiverAccount.getId(), new BigDecimal(100));

    verify(accountRepository).changeAmount(1L, new BigDecimal(900));
    verify(accountRepository).changeAmount(2L, new BigDecimal(1100));
  }

  @Test
  public void moneyTransferNotFoundSenderFlow() {
    long idNotExist = 1L;
    long idUserNotExist = 2L;

    given(accountRepository.findOneAccountById(idNotExist)).willReturn(Optional.empty());

    assertThrows(AccountNotFoundException.class, () -> this.transferService.transferMoney(idNotExist, idUserNotExist, new BigDecimal(100)));

    verify(accountRepository, never()).changeAmount(anyLong(), any());
  }

  @Test
  public void moneyTransferNotFoundReceiverFlow() {
    Account senderAccount = new Account(1L, "dat", new BigDecimal(1000));
    long idNotExist = 2L;

    given(accountRepository.findOneAccountById(senderAccount.getId())).willReturn(Optional.of(senderAccount));
    given(accountRepository.findOneAccountById(idNotExist)).willReturn(Optional.empty());

    assertThrows(AccountNotFoundException.class, () -> this.transferService.transferMoney(senderAccount.getId(), idNotExist, new BigDecimal(100)));

    verify(accountRepository, never()).changeAmount(anyLong(), any());
  }

  @Test void moneyTransferNotEnoughMoneyFlow() {
    Account senderAccount = new Account(1L, "dat", new BigDecimal(1000));
    Account receiverAccount = new Account(2L, "nam", new BigDecimal(1000));

    given(accountRepository.findOneAccountById(senderAccount.getId())).willReturn(Optional.of(senderAccount));
    given(accountRepository.findOneAccountById(receiverAccount.getId())).willReturn(Optional.of(receiverAccount));

    assertThrows(NotEnoughMoneyException.class, () -> this.transferService.transferMoney(senderAccount.getId(), receiverAccount.getId(), new BigDecimal(100000)));

    verify(accountRepository, never()).changeAmount(anyLong(), any());
  }
}
