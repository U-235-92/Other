package com.other.resource_loader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String str = new String(new BufferedInputStream(new FileInputStream(new File("resources\\hello.txt"))).readAllBytes());
		System.out.println(str);
		System.out.println(new File("src\\com\\other\\resource_loader\\test.txt").toURI());
		System.out.println(new File("resources\\hello.txt").toURI());
	}
}
