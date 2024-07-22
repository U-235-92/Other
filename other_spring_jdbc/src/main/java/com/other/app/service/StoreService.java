package com.other.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.other.app.model.Book;
import com.other.app.model.CD;
import com.other.app.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {

	private final StoreRepository storeRepository;
	
	public void storeCD(CD cd) {
		storeRepository.storeCD(cd);
	}
	
	public CD getCDById(long id) {
		return storeRepository.getCDById(id);
	}
	
	public List<CD> getAllCDs() {
		return storeRepository.getAllCDs();
	}
	
	public void storeBook(Book book) {
		storeRepository.storeBook(book);
	}
	
	public Book getBookById(long id) {
		return storeRepository.getBookById(id);
	}
	
	public List<Book> getBookByAuthor(String author) {
		return storeRepository.getBookByAuthor(author);
	}
	
	public List<Book> getAllBooks() {
		return storeRepository.getAllBooks();
	}
}
