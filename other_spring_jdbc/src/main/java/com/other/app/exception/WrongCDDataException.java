package com.other.app.exception;

import java.util.Set;

import com.other.app.model.CD;

import jakarta.validation.ConstraintViolation;

public class WrongCDDataException extends Exception {

	private static final long serialVersionUID = 1L;
	private Set<ConstraintViolation<CD>> constraintViolations;
	
	public WrongCDDataException() {
		super("Wrong CD data exception!");
	}

	public WrongCDDataException(Set<ConstraintViolation<CD>> constraintViolations) {
		this();
		this.constraintViolations = constraintViolations;
	}
	
	public Set<ConstraintViolation<CD>> getConstraintViolation() {
		return constraintViolations;
	}
}
