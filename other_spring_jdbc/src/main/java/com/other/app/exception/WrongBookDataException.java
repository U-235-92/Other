package com.other.app.exception;

import java.util.Set;

import com.other.app.model.Book;

import jakarta.validation.ConstraintViolation;

public class WrongBookDataException extends Exception {

	private static final long serialVersionUID = 1L;
	private Set<ConstraintViolation<Book>> constraintViolations;

	public WrongBookDataException() {
		super("Wrong book data exception!");
	}

	public WrongBookDataException(Set<ConstraintViolation<Book>> constraintViolations) {
		this();
		this.constraintViolations = constraintViolations;
	}

	public Set<ConstraintViolation<Book>> getConstraintViolations() {
		return constraintViolations;
	}
}
