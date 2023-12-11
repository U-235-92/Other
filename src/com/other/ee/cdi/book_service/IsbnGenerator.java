package com.other.ee.cdi.book_service;

import java.util.Random;
import java.util.logging.Logger;

import jakarta.inject.Inject;

@ThirteenDigits
@Loggable
public class IsbnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;
	
	public String generateNumber() {
		String isbn = "12-84356-" + Math.abs(new Random().nextInt());
		logger.info("Сгенерирован ISBN: " + isbn);
		return isbn;
	}

}
