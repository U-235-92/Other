package com.other.json_test.simple_json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class MainSimpleJSON {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File originLibFile = Path.of("src/com/other/json_test/files/LibraryJSON.json").toFile();
		File copyLibFile = Path.of("src/com/other/json_test/files/CopyLibraryJSON.json").toFile();
		SimpleJSON simpleJSON = new SimpleJSON();
//		simpleJSON.getCopyDocument(originLibFile, copyLibFile);
//		simpleJSON.testPrintObject(simpleJSON.testMakeDocument());
//		simpleJSON.testPrintObject(simpleJSON.testReadDocument(originLibFile));
//		simpleJSON.testWriteDocument(destination, simpleJSON.testMakeDocument());
//		simpleJSON.testStreamReadDocument(source);
//		simpleJSON.printBooksLibraryStream(copyLibFile);
		simpleJSON.printBooksLibraryDocument(copyLibFile);
	}

}
