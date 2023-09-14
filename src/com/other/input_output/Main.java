package com.other.input_output;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		Path textPath = Path.of("src/com/other/input_output/text.txt");
		InputOutput inputOutput = new InputOutput();
//		inputOutput.printFileAsIO(textPath);
//		inputOutput.printFileAsNIO(textPath);
//		inputOutput.printFileAsAsynchFutureNIO(textPath);
		inputOutput.printFileAsAsynchCompletionNIO(textPath);
		sleep();
	}

	private static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
