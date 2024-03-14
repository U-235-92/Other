package com.other.spring_fast.chapter_4.comment_service.models;

public class Comment {
	
	private String author;
	private String text;
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Comment [author=" + author + ", text=" + text + "]";
	}
}
