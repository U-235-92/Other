package com.other.xml_test;

import java.io.File;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		File source = Paths.get("src/com/other/xml_test/LibraryDocument.xml").toFile(); 
		DOMLibraryParser domParser = new DOMLibraryParser(source, true);
		domParser.getBooks();
	}
}
