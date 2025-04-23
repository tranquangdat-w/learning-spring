package com.mycompany.resttransaction.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.resttransaction.dto.AccountRowMapper;
import com.mycompany.resttransaction.model.Account;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AccountRepository {
  private final JdbcTemplate jdbc;

  public void setAmount(long userId, BigDecimal amount) {
    String sql = "UPDATE account SET amount = ? WHERE id = ?";

    jdbc.update(sql, amount, userId);
  }

  public List<Account> findAllAccounts() {
    String sql = "SELECT * FROM account";

    return jdbc.query(sql, new AccountRowMapper());
  }

  public Optional<Account> findAccountById(long id) {
    String sql = "SELECT * FROM account WHERE id = ?";

    try {
      Account user = jdbc.queryForObject(sql, new AccountRowMapper(), id);
      return Optional.ofNullable(user);
    } catch (Exception e) {
      return Optional.empty();
    }

  }
}
