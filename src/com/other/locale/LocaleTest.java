package com.other.locale;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale ru_locale = Locale.forLanguageTag("ru-RU");
		double num = 123456.78;
		printLocaleCurrency(ru_locale, num);
		printLocaleLanguageDefault(ru_locale);
		printLocaleLanguageLocale(ru_locale);
	}

	private static void printLocaleCurrency(Locale locale, double currency) {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		System.out.println(currencyFormat.format(currency));		
	}
	
	private static void printLocaleLanguageLocale(Locale locale) {
		System.out.println(locale.getDisplayCountry(locale));
	}
	
	private static void printLocaleLanguageDefault(Locale locale) {
		System.out.println(locale.getDisplayCountry());
	}
}
