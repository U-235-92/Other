package com.other.spring_fast.chapter_13.transaction.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.other.spring_fast.chapter_13.transaction.model.Account;

@Repository
public class AccountRepository {

	@Autowired
	private JdbcTemplate jdbc;
	private RowMapper<Account> rowMapper = (resultSet, rowNumber) -> {
		Account a = new Account();
		a.setId(resultSet.getInt("id"));
		a.setName(resultSet.getString("name"));
		a.setAmount(resultSet.getBigDecimal("amount"));
		return a;
	};
	
	public Account findAccountById(long id) {
		String sql = "Select * From account Where id = ?";
		return jdbc.queryForObject(sql, rowMapper, id);
	}
	
	public List<Account> findAllAccounts() {
		String sql = "Select * From account";
		return jdbc.query(sql, rowMapper);
	}
	
	public void changeAmount(long id, BigDecimal amount) {
		String sql = "Update account Set amount = ? Where id = ?";
		jdbc.update(sql, amount, id);
	}
}
