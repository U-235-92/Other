package com.other.io_nio.copy_file;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path src = Path.of("src/com/other/io_nio/copy_file/test.txt");
		Path target = Path.of("src/com/other/io_nio/copy_file/testCopy.txt");
//		IOCopy.copy(src, target);
//		NIOCopy.copy(src, target);
		NIOCopy.copyAsync(src, target);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
