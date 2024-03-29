package com.other.spring_fast.chapter_13.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.other.spring_fast.chapter_13.transaction.model.Account;
import com.other.spring_fast.chapter_13.transaction.model.TransferRequest;
import com.other.spring_fast.chapter_13.transaction.service.TransferService;

@RestController
public class AccountController {

	@Autowired
	private TransferService transferService;
	
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest request) {
		transferService.transferMoney(request.getSenderAccountId(), request.getReceiverAccountId(), request.getAmount());
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return transferService.getAllAccounts();
	}
}
