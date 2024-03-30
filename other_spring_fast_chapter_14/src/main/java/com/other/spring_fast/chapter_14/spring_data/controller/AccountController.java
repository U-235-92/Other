package com.other.spring_fast.chapter_14.spring_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.other.spring_fast.chapter_14.spring_data.model.Account;
import com.other.spring_fast.chapter_14.spring_data.model.TransferRequest;
import com.other.spring_fast.chapter_14.spring_data.service.TransferService;

@RestController
public class AccountController {

	@Autowired
	private TransferService transferService;
	
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest request) {
		transferService.transferMoney(request.getSenderAccountId(), request.getReceiverAccountId(), request.getAmount());
	}
	
	@GetMapping("/accounts") 
	public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
		if(name == null) {
			return transferService.getAllAccounts();
		} else {
			return transferService.findAccountsByName(name);
		}
	}
}
