package com.mycompany.springdata.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.springdata.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
  @Query("SELECT * FROM account WHERE name := NAME")
  List<Account> findAccountsByName(String name); 

  @Modifying
  @Query("UPDATE account SET amount := amount WHERE id := id")
  void changeAmount(long id, BigDecimal amount);

  @Query("SELECT * FROM account WHERE id := id")
  Account findOneAccountById(long id);
}
