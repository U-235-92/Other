package com.other.input_output;

import java.nio.file.Path;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Path textPath = Path.of("src/com/other/input_output/text.txt");
		Path textPath2 = Path.of("src/com/other/input_output/text2.txt");
		Path textPath3 = Path.of("src/com/other");
		Path zipSourcePath = Path.of("src/tmp");
		Path zipDestinationPath = Path.of("src/tmp_zip.zip");
		Path unzipDestinationPath = Path.of("src/tmp_unzip");
		InputOutput inputOutput = new InputOutput();
//		inputOutput.printFileAsIO(textPath);
//		inputOutput.printFileAsNIO(textPath);
//		inputOutput.printFileAsAsynchFutureNIO(textPath);
//		inputOutput.printFileAsAsynchCompletionNIO(textPath);
//		inputOutput.writeStringAsNIO(textPath2, "Just for fun");
//		inputOutput.writeStringAsAsynchFutureNIO(textPath2, "Asynchronous test write");
//		inputOutput.writeStringAsAsynchCompletionNIO(textPath2, "Asynchronous completion test write");
//		inputOutput.makeAnOldFile();
//		inputOutput.getFileMetaData(textPath2);
//		inputOutput.printDirectoryContentByWalk(textPath3);
//		inputOutput.printDirectoryContentByDirectoryStream(textPath3);
//		inputOutput.printDirectoryContentByFileVisitor(textPath3);
//		inputOutput.printDirectoryContentByRecursion(textPath3);
//		inputOutput.makeDirectories(zipSourcePath);
//		inputOutput.deleteDirectory(zipSourcePath);
//		inputOutput.zip(zipSourcePath, zipDestinationPath);
		inputOutput.unzip(zipDestinationPath, unzipDestinationPath);
//		inputOutput.deleteDirectory(unzipDestinationPath);
//		sleep();
	}

	@SuppressWarnings("unused")
	private static void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
