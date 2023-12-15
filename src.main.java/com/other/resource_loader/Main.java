package com.other.resource_loader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {

	public static void main(String[] args) throws IOException {
		String str = getStringImage(new File("src/picture.jpg"));
		System.out.println(str);
		getCopy(new File("src/picture.jpg"));
		getCopy2(new File("src/about.txt"), new File("src/copyAbout.txt"));
	}

	private static String getStringImage(File file) {
		String result = null;
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			byte[] bytes = fis.readAllBytes();
			result = new String(Base64.getEncoder().encode(bytes), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static void getCopy(File file) throws FileNotFoundException, IOException {
		try(InputStream in = new FileInputStream(file);
				OutputStream out = new FileOutputStream("src/copy.jpg")) {
			byte[] bytes = new byte[1024];
			while(in.read(bytes) != -1) {
				out.write(bytes);
			}
		}
		System.out.println("SUCCESS");
	}
	
	private static void getCopy2(File from, File to) {
		try {
			Files.copy(Path.of(from.getPath()), Path.of(to.getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SUCCESS");
	}
}
