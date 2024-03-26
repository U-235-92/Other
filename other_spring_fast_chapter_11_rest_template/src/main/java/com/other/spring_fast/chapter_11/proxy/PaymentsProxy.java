package com.other.spring_fast.chapter_11.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.other.spring_fast.chapter_11.model.Payment;

@Component
public class PaymentsProxy {

	@Autowired
	private RestTemplate rest;
	@Value("${name.service.url}")
	private String paymentsServiceUrl;
	
	public Payment createPayment(Payment payment) {
		String uri = paymentsServiceUrl + "/payment";
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("requestId", UUID.randomUUID().toString());
		HttpEntity<Payment> httpEntity = new HttpEntity<Payment>(payment, httpHeaders);
		ResponseEntity<Payment> response = rest
				.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
		return response.getBody();
	}
}
