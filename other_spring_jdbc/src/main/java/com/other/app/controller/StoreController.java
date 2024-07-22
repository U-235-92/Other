package com.other.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.other.app.exception.WrongBookDataException;
import com.other.app.exception.WrongCDDataException;
import com.other.app.model.Book;
import com.other.app.model.CD;
import com.other.app.model.Item;
import com.other.app.service.StoreService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store")
public class StoreController {

	private final Validator validator;
	private final StoreService storeService;
	
	@PostMapping("/put_cd")
	public ResponseEntity<String> storeCD(@RequestBody CD cd) throws WrongCDDataException  {
		Set<ConstraintViolation<CD>> constraintViolations = getConstraintViolations(cd);
		if(!isValid(constraintViolations)) {
			throw new WrongCDDataException(constraintViolations);
		}
		storeService.storeCD(cd);
		return ResponseEntity.ok().body("CD added success!");
	}
	
	@GetMapping("/get_cd/{id}")
	public ResponseEntity<CD> getCDById(@PathVariable long id) {
		CD cd = storeService.getCDById(id);
		if(cd != null) {
			return ResponseEntity.ok().body(cd);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/get_all_cds")
	public ResponseEntity<List<CD>> getAllCDs() {
		List<CD> cds = storeService.getAllCDs();
		if(cds.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cds);
	}
	
	@PostMapping("/put_book")
	public ResponseEntity<String> storeBook(@RequestBody Book book) throws WrongBookDataException  {
		Set<ConstraintViolation<Book>> constraintViolations = getConstraintViolations(book);
		if(!isValid(constraintViolations)) {
			throw new WrongBookDataException(constraintViolations);
		}
		storeService.storeBook(book);
		return ResponseEntity.ok().body("Book added success!");
	}
	
	@GetMapping("/get_book_by_id/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable long id) {
		Book book = storeService.getBookById(id);
		if(book != null) {
			return ResponseEntity.ok().body(book);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/get_book_by_author/{author}")
	public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String author) {
		List<Book> books = storeService.getBookByAuthor(author);
		if(books != null) {
			return ResponseEntity.ok().body(books);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/get_all_books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = storeService.getAllBooks();
		if(books.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(books);
	}
		
	private <T extends Item> boolean isValid(Set<ConstraintViolation<T>> constraintViolations) {
		return constraintViolations.isEmpty();
	}
	
	private <T extends Item> Set<ConstraintViolation<T>> getConstraintViolations(T obj) {
		return validator.validate(obj);
	}
}
