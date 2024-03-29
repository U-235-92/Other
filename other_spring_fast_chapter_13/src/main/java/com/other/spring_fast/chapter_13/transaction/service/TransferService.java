package com.other.spring_fast.chapter_13.transaction.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.other.spring_fast.chapter_13.transaction.model.Account;
import com.other.spring_fast.chapter_13.transaction.repository.AccountRepository;

@Service
@Transactional
public class TransferService {

	@Autowired
	private AccountRepository accountRepository;
	
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
		Account sender = accountRepository.findAccountById(idSender);
		Account receiver = accountRepository.findAccountById(idReceiver);
		BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
		BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
		accountRepository.changeAmount(idSender, senderNewAmount);
		accountRepository.changeAmount(idReceiver, receiverNewAmount);
		throw new RuntimeException("Oh no! Something went wrong!");
	}
	
	public List<Account> getAllAccounts() {
		return accountRepository.findAllAccounts();
	}
}
