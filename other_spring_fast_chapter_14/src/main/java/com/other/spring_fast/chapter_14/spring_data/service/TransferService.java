package com.other.spring_fast.chapter_14.spring_data.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.other.spring_fast.chapter_14.spring_data.model.Account;
import com.other.spring_fast.chapter_14.spring_data.repository.AccountRepository;
import com.other.spring_fast.chapter_14.spring_data.util.AccountNotFoundException;

@Service
@Transactional
public class TransferService {

	@Autowired
	private AccountRepository accountRepository;
	
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
		Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
		Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());
		BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
		BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
		accountRepository.changeAmount(idSender, senderNewAmount);
		accountRepository.changeAmount(idReceiver, receiverNewAmount);
	}
	
	public Iterable<Account> getAllAccounts() {
		return accountRepository.findAll();
	}
	
	public List<Account> findAccountsByName(String name) {
		return accountRepository.findAccountsByName(name);
	}
}
