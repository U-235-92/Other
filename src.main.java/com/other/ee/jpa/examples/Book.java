package com.other.ee.jpa.examples;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;

@Entity
@Access(AccessType.FIELD)
public class Book extends Item {

	private String title;
	private String author;
	private int numberOfPages;
	
	public Book() {
		super();
	}

	public Book(String title, String author, int numberOfPages) {
		super();
		this.title = title;
		this.author = author;
		this.numberOfPages = numberOfPages;
	}

	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", numberOfPages=" + numberOfPages + "price=" + getPrice() + ", id=" + getId() + "]";
	}
}
