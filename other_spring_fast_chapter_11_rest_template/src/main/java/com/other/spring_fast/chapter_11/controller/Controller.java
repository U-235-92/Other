package com.other.spring_fast.chapter_11.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.other.spring_fast.chapter_11.model.Payment;
import com.other.spring_fast.chapter_11.proxy.PaymentsProxy;

@RestController
public class Controller {

	private final PaymentsProxy paymentsProxy;

	public Controller(PaymentsProxy paymentsProxy) {
		super();
		this.paymentsProxy = paymentsProxy;
	}
	
	@PostMapping("/payment")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentsProxy.createPayment(payment);
	}
}
