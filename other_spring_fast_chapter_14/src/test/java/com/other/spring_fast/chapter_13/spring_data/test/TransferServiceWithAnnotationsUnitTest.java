package com.other.spring_fast.chapter_13.spring_data.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.other.spring_fast.chapter_14.spring_data.model.Account;
import com.other.spring_fast.chapter_14.spring_data.repository.AccountRepository;
import com.other.spring_fast.chapter_14.spring_data.service.TransferService;
import com.other.spring_fast.chapter_14.spring_data.util.AccountNotFoundException;

@ExtendWith(MockitoExtension.class)
public class TransferServiceWithAnnotationsUnitTest {

	@Mock
	private AccountRepository accountRepositoryMock;
	
	@InjectMocks
	private TransferService transferService;
	
	@Test
	@DisplayName("Test the amount is transferred from one account to another if no exception occurs.")
	public void moneyTransferHappyFlow() {
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
	
	@Test
	public void moneyTransferDestinationAccountNotFoundFlow() {
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(new BigDecimal(1000));
		BDDMockito.given(accountRepositoryMock.findById(sender.getId())).willReturn(Optional.of(sender));
		BDDMockito.given(accountRepositoryMock.findById(2L)).willReturn(Optional.empty());
		assertThrows(AccountNotFoundException.class, () -> transferService.transferMoney(1, 2, new BigDecimal(100)));
		Mockito.verify(accountRepositoryMock, never()).changeAmount(anyLong(), any());
	}
}
