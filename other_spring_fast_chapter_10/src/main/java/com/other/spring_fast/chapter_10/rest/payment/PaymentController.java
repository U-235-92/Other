package com.other.spring_fast.chapter_10.rest.payment;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payment") 
	public ResponseEntity<?> makePayment() {
		try {
			PaymentDetails paymentDetails = paymentService.processPayment();
			return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(paymentDetails);
		} catch(NotEnoughMoneyException e) {
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setMessage("Not enough money to make the payment.");
			return ResponseEntity
					.badRequest()
					.body(errorDetails);
		}
	}
	
	@GetMapping("/payment2")
	public ResponseEntity<PaymentDetails> makePayment2() {
		PaymentDetails paymentDetails = paymentService.processPayment();
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(paymentDetails);
	}
	
	@PostMapping("/payment3")
	public ResponseEntity<PaymentDetails> makePayment3(@RequestBody PaymentDetails paymentDetails) {
		logger.info("Received payment " + paymentDetails.getAmount());
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(paymentDetails);
	}
}
