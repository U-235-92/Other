package com.other.spring_fast.chapter_11.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.other.spring_fast.chapter_11.model.Payment;

import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {

	@Value("${name.service.url}")
	private String url;
	private final WebClient webClient;

	public PaymentsProxy(WebClient webClient) {
		super();
		this.webClient = webClient;
	}

	public Mono<Payment> createPayment(String requestId, Payment payment) {
		return webClient
				.post()
				.uri(url + "/payment")
				.header("requestId", requestId)
				.body(Mono.just(payment), Payment.class)
				.retrieve()
				.bodyToMono(Payment.class);
	}
}
