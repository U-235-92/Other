package com.other.input_output;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class InputOutput {

	public void printFileAsIO(Path path) {
		try(FileInputStream fis = new FileInputStream(path.toFile());
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr)) {
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("IO RESULT:");
			System.out.println(sb);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printFileAsNIO(Path path) {
		try(FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(4);
			StringBuilder sb = new StringBuilder();
			while(fileChannel.read(byteBuffer) > 0) {
				byteBuffer.flip();
				sb.append(new String(byteBuffer.array(), 0, byteBuffer.limit()));
				byteBuffer.clear();
			}
			System.out.println("NIO RESULT:");
			System.out.println(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printFileAsAsynchFutureNIO(Path path) {
		try(AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
			int buffSize = 256;
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) (asynchronousFileChannel.size() > buffSize ? asynchronousFileChannel.size() : buffSize));
			Future<Integer> future = asynchronousFileChannel.read(byteBuffer, 0);
			future.get();
			StringBuilder sb = new StringBuilder();
			sb.append(new String(byteBuffer.array()));
			System.out.println("ASYNCHRONOUS FUTURE:");
			System.out.println(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printFileAsAsynchCompletionNIO(Path path) {
		try(AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
			int buffSize = 256;
			ByteBuffer byteBuffer = ByteBuffer.allocate((int) (asynchronousFileChannel.size() > buffSize  ? asynchronousFileChannel.size() : buffSize));
			asynchronousFileChannel.read(byteBuffer, 0, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {

				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					System.out.println("ASYNCHRONOUS COMPLETION:");
					System.out.println(new String(byteBuffer.array()));
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					exc.printStackTrace();
				}
				
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeStringAsIO(Path path, String string) {
		
	}
	
	public void writeStringAsNIO(Path path, String string) {
		
	}
	
	public void writeStringAsAsynchFutureNIO(Path path, String string) {
		
	}
	
	public void writeStringAsAsynchCompletionNIO(Path path, String string) {
		
	}
}
