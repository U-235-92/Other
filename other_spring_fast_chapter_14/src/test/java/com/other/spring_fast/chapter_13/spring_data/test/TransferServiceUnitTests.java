package com.other.spring_fast.chapter_13.spring_data.test;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import com.other.spring_fast.chapter_14.spring_data.model.Account;
import com.other.spring_fast.chapter_14.spring_data.repository.AccountRepository;
import com.other.spring_fast.chapter_14.spring_data.service.TransferService;

public class TransferServiceUnitTests {

	@Test
	@DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
	public void moneyTransferHappyFlow() {
		AccountRepository accountRepositoryMock = Mockito.mock(AccountRepository.class);
		TransferService transferService = new TransferService(accountRepositoryMock);
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(new BigDecimal(1000));
		Account destination = new Account();
		destination.setId(2);
		destination.setAmount(new BigDecimal(1000));
		BDDMockito.given(accountRepositoryMock.findById(sender.getId())).willReturn(Optional.of(sender));
		BDDMockito.given(accountRepositoryMock.findById(destination.getId())).willReturn(Optional.of(destination));
		transferService.transferMoney(sender.getId(), destination.getId(), new BigDecimal(100));
		Mockito.verify(accountRepositoryMock).changeAmount(1, new BigDecimal(900));
		Mockito.verify(accountRepositoryMock).changeAmount(2, new BigDecimal(1100));
	}
}
