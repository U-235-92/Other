package com.other.spring_fast.chapter_10.rest.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public PaymentDetails processPayment() {
		throw new NotEnoughMoneyException();
	}
}
