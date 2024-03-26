package com.other.spring_fast.chapter_11.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.other.spring_fast.chapter_11.model.Payment;
import com.other.spring_fast.chapter_11.proxy.PaymentsProxy;

import reactor.core.publisher.Mono;

@RestController
public class PaymentsController {

	@Autowired
	private PaymentsProxy paymentsProxy;
	
	@PostMapping("/payment")
	public Mono<Payment> createPayment(@RequestBody Payment payment) {
		String requestId = UUID.randomUUID().toString();
		return paymentsProxy.createPayment(requestId, payment);
	}
	
}
