package com.other.json_test.simple_json_javax;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.other.json_test.obj.Book;

public class MainSimpleJsonJavax {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		File originLibFile = Path.of("src/com/other/json_test/files/LibraryJSON.json").toFile();
		File copyLibFile = Path.of("src/com/other/json_test/files/CopyLibraryJSON.json").toFile();
		File customLibFile = Path.of("src/com/other/json_test/files/CustomLibraryJSON.json").toFile();
		SimpleJsonJavax simpleJSON = new SimpleJsonJavax();
//		simpleJSON.getCopyDocument(originLibFile, copyLibFile);
//		simpleJSON.printObject(simpleJSON.testMakeDocument());
//		simpleJSON.printObject(simpleJSON.readObject(originLibFile));
//		simpleJSON.writeObject(customLibFile, simpleJSON.testMakeDocument());
//		simpleJSON.printDocument(originLibFile);
//		simpleJSON.printBooksLibraryStream(copyLibFile);
		simpleJSON.printBooksLibraryDocument(copyLibFile);
//		simpleJSON.addBookDocument(copyLibFile, initBook());
//		simpleJSON.editBookDocument(copyLibFile, "BN-99", "Роман-эпопея", "Вечный зов. Том 1", new ArrayList<>());
//		simpleJSON.removeBookDocument(copyLibFile, "BN-99");
	}
	
	@SuppressWarnings("unused")
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
