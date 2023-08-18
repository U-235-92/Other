package com.other.xml_test;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//TEST
		File source = Paths.get("src/com/other/xml_test/LibraryDocument.xml").toFile(); 
		File destination = Paths.get("src/com/other/xml_test/LibraryDocumentCopy.xml").toFile(); 
		LibraryDocumentHandlerDOM domHandler = new LibraryDocumentHandlerDOM(true, true);
//		domHandler.addBook(source, destination, initBook());
//		domHandler.editBook(destination, destination, "BN-99", null, "Вечный зов. Том 1", null);
//		domHandler.removeBook(destination, destination, "BN-99");
//		domHandler.printBooks(domHandler.searchBookByAuthor(source, "Джеймс Клавелл"));
//		domHandler.printBooks(domHandler.searchBookByTitle(source, "Война и мир"));
	}
	
	private static Book initBook() {
		Book book = new Book();
		List<String> authorList = new ArrayList<>();
		authorList.add("Анатолий Иваноов");
		book.setAuthors(authorList);
		book.setId("BN-99");
		book.setTitle("Вечный зов");
		book.setType("Роман-эпопея");
		return book;
	}
}
