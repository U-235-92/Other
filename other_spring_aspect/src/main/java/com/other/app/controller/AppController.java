package com.other.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.other.app.dto.PersonCardDTO;
import com.other.app.exception.BadCreditionalsPersonCardException;
import com.other.app.model.PersonCard;
import com.other.app.service.AppService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class AppController {

	private final AppService service;
	private final Validator validator;
	
	@GetMapping("/get_person_cards")
	public ResponseEntity<List<PersonCard>> getPersonCards() {
		return ResponseEntity.ok(service.getPersonCards());
	}
	
	@PostMapping("/add_person_card_advice")
	public ResponseEntity<String> addPersonCardAdvice(@RequestBody PersonCardDTO personCardDTO) throws BadCreditionalsPersonCardException {
		Set<ConstraintViolation<PersonCardDTO>> constraintViolations = validator.validate(personCardDTO);
		if(!constraintViolations.isEmpty()) {
			throw new BadCreditionalsPersonCardException(constraintViolations);
		}
		service.addPersonCard(personCardDTO);
		return ResponseEntity.ok("Person card added success");
	}
	
	@PostMapping("/add_person_card_aspect")
	public ResponseEntity<String> addPersonCardAspect(@RequestBody PersonCardDTO personCardDTO) {
		service.addPersonCard(personCardDTO);
		return ResponseEntity.ok("Person card added success");
	}
}
