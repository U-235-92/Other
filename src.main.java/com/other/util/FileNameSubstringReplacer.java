package com.other.util;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

import javax.swing.filechooser.FileSystemView;

public final class FileNameSubstringReplacer {

	public static void replaceFileSubstring(Path folder, String replaced, String replacement) throws IOException {
		Files.newDirectoryStream(folder).forEach(path -> {
			if(!Files.isDirectory(path)) {
				System.out.println(path);
			}
		});
	}
	
	public static void main(String[] args) {
//		try {
//			FileNameSubstringReplacer.replaceFileSubstring(Paths.get("Redmi 9T\\Внутренний общий накопитель\\Download\\Telegram"), null, null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
