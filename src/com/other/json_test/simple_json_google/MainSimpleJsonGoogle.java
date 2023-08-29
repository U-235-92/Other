package com.other.json_test.simple_json_google;

import java.io.File;
import java.nio.file.Path;

public class MainSimpleJsonGoogle {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		File originLibFile = Path.of("src/com/other/json_test/files/LibraryJSON.json").toFile();
		File copyLibFile = Path.of("src/com/other/json_test/files/CopyLibraryJSON.json").toFile();
		File customLibFile = Path.of("src/com/other/json_test/files/CustomLibraryJSON.json").toFile();
		SimpleJsonGoogle simpleJsonGoogle = new SimpleJsonGoogle();
//		simpleJsonGoogle.printBooks(copyLibFile);
//		simpleJsonGoogle.printDocument(copyLibFile);
		simpleJsonGoogle.printJsonObject(simpleJsonGoogle.makeJson());
	}
}
