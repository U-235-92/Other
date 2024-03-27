package com.other.spring_fast.chapter_12.db.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.other.spring_fast.chapter_12.db.model.Purchase;
import com.other.spring_fast.chapter_12.db.repository.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	private final PurchaseRepository purchaseRepository;
	
	public PurchaseController(PurchaseRepository purchaseRepository) {
		super();
		this.purchaseRepository = purchaseRepository;
	}

	@PostMapping
	public void storePurchase(@RequestBody Purchase purchase) {
		purchaseRepository.storePurchase(purchase);
	}
	
	@GetMapping
	public List<Purchase> findPurchases() {
		return purchaseRepository.findAllPurchases();
	}
}
