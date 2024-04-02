package com.other.spring_fast.chapter_13.spring_data.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.other.spring_fast.chapter_14.spring_data.model.Account;
import com.other.spring_fast.chapter_14.spring_data.repository.AccountRepository;
import com.other.spring_fast.chapter_14.spring_data.service.TransferService;

@SpringBootTest(classes = {AccountRepository.class, TransferService.class})
public class TransferServiceSpringIntegrationTests {

	@MockBean
	private AccountRepository accountRepository;
	@Autowired
	private TransferService transferService;
	
	@Test
	public void transferServiceTransferAmountTest() {
		Account sender = new Account();
		sender.setId(1);
		sender.setAmount(new BigDecimal(1000));
		Account destination = new Account();
		destination.setId(2);
		destination.setAmount(new BigDecimal(1000));
		when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
		when(accountRepository.findById(2L)).thenReturn(Optional.of(destination));
		transferService.transferMoney(1, 2, new BigDecimal(100));
		verify(accountRepository).changeAmount(1, new BigDecimal(900));
		verify(accountRepository).changeAmount(2, new BigDecimal(1100));
	}
}
