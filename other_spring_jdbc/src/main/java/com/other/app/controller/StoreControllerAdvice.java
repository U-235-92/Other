package com.other.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.other.app.exception.WrongBookDataException;
import com.other.app.exception.WrongCDDataException;

@RestControllerAdvice
public class StoreControllerAdvice {
	
	@ExceptionHandler(WrongBookDataException.class)
	public ResponseEntity<String> exceptionWrongBookData(WrongBookDataException wrongBookDataException) {
		String errorDetails = "No valid book data: " + wrongBookDataException
				.getConstraintViolations()
				.stream()
				.map(constraintViolation -> constraintViolation.getPropertyPath().toString() + " " +  constraintViolation.getMessage() + " ")
				.reduce("", (t, u) -> t.concat(u));
		return ResponseEntity
				.badRequest()
				.body(errorDetails);
	}
	
	@ExceptionHandler(WrongCDDataException.class)
	public ResponseEntity<String> exceptionWrongCDData(WrongCDDataException wrongCDDataException) {
		String errorDetails = "No valid CD data: " + wrongCDDataException
				.getConstraintViolation()
				.stream()
				.map(constraintViolation -> constraintViolation.getPropertyPath().toString() + " " +  constraintViolation.getMessage() + " ")
				.reduce("", (t, u) -> t.concat(u));
		return ResponseEntity
				.badRequest()
				.body(errorDetails);
	}
}
