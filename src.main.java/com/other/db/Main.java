package com.other.db;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAOManager manager = new DAOManager();
//		manager.addBooks(getBooks());
//		manager.addBook(new Book("F", "id-0933", List.of("Someone"), 100.00));
		manager.testRowSet();
	}
	
	@SuppressWarnings("unused")
	private static List<Book> getBooks() {
		List<String> authorsOfBookA = List.of("Karl Hacker", "Garry Cracker");
		List<String> authorsOfBookB = List.of("Karl Hacker");
		List<String> authorsOfBookC = List.of("John Liskov", "Kim Li");
		Book a = new Book("A", "id-9453", authorsOfBookA, 9.99);
		Book b = new Book("B", "id-8551", authorsOfBookB, 20.15);
		Book c = new Book("C", "id-7384", authorsOfBookC, 1.99);
		List<Book> books = List.of(a, b, c);
		return books;
	}

}
