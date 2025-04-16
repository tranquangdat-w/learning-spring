package com.mycompany.restwebapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.restwebapp.model.Purchase;


@Repository
public class PurchaseRepository {
  private final JdbcTemplate jdbc;

  public PurchaseRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public void storePurchase(Purchase purchase) {
    String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";

    jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
  }
}
