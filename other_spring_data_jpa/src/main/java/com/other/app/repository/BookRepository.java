package com.other.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.other.app.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query(value = "SELECT b FROM Book b")
	public List<Book> testJPAQuery();
}
