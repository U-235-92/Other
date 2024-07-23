package com.other.app.exception;

import java.util.Set;

import com.other.app.dto.PersonCardDTO;

import jakarta.validation.ConstraintViolation;

public class BadCreditionalsPersonCardException extends Exception {

	private static final long serialVersionUID = 1L;
	private Set<ConstraintViolation<PersonCardDTO>> constraintViolations;
	
	public BadCreditionalsPersonCardException(Set<ConstraintViolation<PersonCardDTO>> constraintViolations) {
		super();
		this.constraintViolations = constraintViolations;
	}
	
	@Override
	public String getMessage() {
		String violations = constraintViolations
				.stream()
				.map(violation -> violation.getPropertyPath() + " = " + violation.getInvalidValue() + " ")
				.reduce("", (s1, s2) -> s1.concat(s2));
		return "Invalid person card data -> " + violations;
	}

}
