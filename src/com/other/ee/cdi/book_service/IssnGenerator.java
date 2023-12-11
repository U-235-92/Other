package com.other.ee.cdi.book_service;

import java.util.Random;
import java.util.logging.Logger;

import jakarta.inject.Inject;

@EightDigits
@Loggable
public class IssnGenerator implements NumberGenerator {

	@Inject
	private Logger logger;
	
	public String generateNumber() {
		String issn = "8-" + Math.abs(new Random().nextInt());
		logger.info("Сгенерирован ISSN: " + issn);
		return issn;
	}

}
