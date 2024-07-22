package com.other.app.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.other.app.model.Book;
import com.other.app.model.CD;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class StoreRepository {

	private final JdbcTemplate jdbcTemplate;
	
	public void storeBook(Book book) {
		String sql = "INSERT INTO books(author, title, price) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, book.getAuthor(), book.getTitle(), book.getPrice());
	}
	
	public List<Book> getAllBooks() {
		String sql = "SELECT * FROM books";
		return jdbcTemplate.query(sql, bookRowMapper());
	}
	
	public Book getBookById(long id) {
		String sql = "SELECT * FROM books WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, bookRowMapper(), Long.valueOf(id));
	}
	
	public List<Book> getBookByAuthor(String author) {
		String sql = "SELECT * FROM books WHERE author = ?";
		return jdbcTemplate.query(sql, bookRowMapper(), author);
	}
	
	private RowMapper<Book> bookRowMapper() {
		return (rs, rowNum) -> {
			Book book = new Book();
			book.setId(rs.getLong("id"));
			book.setAuthor(rs.getString("author"));
			book.setTitle(rs.getString("title"));
			book.setPrice(rs.getBigDecimal("price"));
			return book;
		};
	}
	
	public void storeCD(CD cd) {
		String sql = "INSERT INTO cds(size, price) VALUES (?, ?)";
		jdbcTemplate.update(sql, cd.getSize(), cd.getPrice());
	}
	
	public List<CD> getAllCDs() {
		String sql = "SELECT * FROM cds";
		return jdbcTemplate.query(sql, cdRowMapper());
	}
	
	public CD getCDById(long id) {
		String sql = "SELECT * FROM cds WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, cdRowMapper(), Long.valueOf(id));
	}
	
	private RowMapper<CD> cdRowMapper() {
		RowMapper<CD> cdRowMapper = (rs, rowNum) -> {
			CD cd = new CD();
			cd.setId(rs.getLong("id"));
			cd.setPrice(rs.getBigDecimal("price"));
			cd.setSize(rs.getInt("size"));
			return cd;
		};
		return cdRowMapper;
	}
}
