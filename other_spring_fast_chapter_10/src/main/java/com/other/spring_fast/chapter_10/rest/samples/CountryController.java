package com.other.spring_fast.chapter_10.rest.samples;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	@GetMapping("/france") 
	public ResponseEntity<Country> france() {
		Country country = Country.of("France", 67);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.header("continent", "Europe")
				.header("capital", "Paris")
				.header("favorite_food", "cheese and whine")
				.body(country);
	}
	
	@GetMapping("/all") 
	public List<Country> countries() {
		Country c1 = Country.of("France", 67);
		Country c2 = Country.of("Spain", 47);
		return List.of(c1, c2);
	}
}
