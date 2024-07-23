package com.other.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.other.app.exception.BadCreditionalsPersonCardException;

@RestControllerAdvice
public class AppControllerAdvice {

	@ExceptionHandler(BadCreditionalsPersonCardException.class)
	public ResponseEntity<String> handleException(BadCreditionalsPersonCardException exception) {
		return ResponseEntity.badRequest().body("Incorrect data of person card: " + exception.getMessage());
	}
}
