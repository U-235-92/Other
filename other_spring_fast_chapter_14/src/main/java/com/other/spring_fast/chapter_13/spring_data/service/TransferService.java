package com.other.spring_fast.chapter_13.spring_data.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.other.spring_fast.chapter_13.spring_data.model.Account;
import com.other.spring_fast.chapter_13.spring_data.repository.AccountRepository;
import com.other.spring_fast.chapter_13.spring_data.util.AccountNotFoundException;

@Service
@Transactional
public class TransferService {

	private final AccountRepository accountRepository;

	public TransferService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
		Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
		Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());
		BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
		BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
		accountRepository.changeAmount(idSender, senderNewAmount);
		accountRepository.changeAmount(idReceiver, receiverNewAmount);
	}
}
