package com.other.xml_test;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private String title = "";
	private List<String> authors = new ArrayList<>();
	private String id;
	private String type;
	
	public Book() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return title + " " + authors.toString();
	}
}
