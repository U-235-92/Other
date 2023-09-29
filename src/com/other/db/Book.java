package com.other.db;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class Book {

	private String title;
	private String isbn;
	private List<String> authors;
	private double price;
	
	private Locale locale = Locale.getDefault();
	private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
	
	public Book(String title, String isbn, List<String> authors, double price) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public List<String> getAuthors() {
		return authors;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getFormatedPrice() {
		String formattedPrice = currencyFormat.format(price);
		return formattedPrice;
	}
	
	public double parsePrice(String formattedPrice) {
		try {
			Number number = currencyFormat.parse(formattedPrice);
			double price = number.doubleValue();
			return price;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1.0;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", authors=" + authors + ", price=" + price + "]";
	}
}
