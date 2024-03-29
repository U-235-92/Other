package com.other.spring_fast.chapter_13.spring_data.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.other.spring_fast.chapter_13.spring_data.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	@Query("Select * From account Where name = :name")
	List<Account> findAccountsByName(String name);
	
	@Modifying
	@Query("Update account Set amount = :amount Where id = :id")
	void changeAmount(long id, BigDecimal amount);
}
