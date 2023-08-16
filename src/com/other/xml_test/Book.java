package com.other.xml_test;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private String title = "";
	private List<String> authors = new ArrayList<>();
	
	public Book() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthor() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	@Override
	public String toString() {
		return title + " " + authors.toString();
	}
}
