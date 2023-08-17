package com.other.xml_test;

import java.io.File;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		//TEST
		File source = Paths.get("src/com/other/xml_test/LibraryDocument.xml").toFile(); 
		LibraryDocumentHandlerDOM domParser = new LibraryDocumentHandlerDOM(true);
		System.out.println("Before edit...");
		domParser.showBooks(source);
		System.out.println("After edit...");
		domParser.editLibrary(source);
		SAXLibraryParser saxParser = new SAXLibraryParser(source);
//		saxParser.parseBooks();
		STAXLibraryParser staxParser = new STAXLibraryParser(source);
//		staxParser.parseBooks();
	}
}
