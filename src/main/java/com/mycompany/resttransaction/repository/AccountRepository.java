package com.mycompany.resttransaction.repository;

import java.math.BigDecimal;
import java.util.List;

import org.bouncycastle.util.Objects;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.resttransaction.dto.AccountRowMapper;
import com.mycompany.resttransaction.model.Account;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AccountRepository {
  private final JdbcTemplate jdbc; 

  public void setAmount(int userId, BigDecimal amount) {
    String sql = "UPDATE account set amount = ? where id = ?";

    jdbc.update(sql, amount, userId);
  }

  public List<Account> findAllAccounts() {
    String sql = "select * from account";

    return jdbc.query(sql, new AccountRowMapper());
  }

  public Account findAccountById(long id) {
    String sql = "select * from account where id = ?";

    return jdbc.queryForObject(sql, new AccountRowMapper(), id);
  }
}
