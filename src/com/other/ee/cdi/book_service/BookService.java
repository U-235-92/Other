package com.other.ee.cdi.book_service;

import jakarta.inject.Inject;

public class BookService {

	@Inject 
	@ThirteenDigits
	private NumberGenerator numberGenerator;
	
	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		return book;
	}
}
