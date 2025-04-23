package com.mycompany.resttransaction.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mycompany.resttransaction.model.Account;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
    Account accountObject = new Account();

    accountObject.setId(rs.getInt("id"));
    accountObject.setAmount(rs.getBigDecimal("amount"));
    accountObject.setUsername(rs.getString("name"));
    return accountObject;
	}
}

