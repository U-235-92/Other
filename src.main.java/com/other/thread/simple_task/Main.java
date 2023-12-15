package com.other.thread.simple_task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService fixPool = Executors.newFixedThreadPool(2);
		Future<String> task1 = fixPool.submit(() -> {
			System.out.println("Start t1");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("t1");
			return "TASK 1";
		});
		Future<String> task2 = fixPool.submit(() -> {
			System.out.println("Start t2");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("t2");
			return "TASK 2";
		});
		Future<String> task3 = fixPool.submit(() -> {
			System.out.println("Start t3");
			TimeUnit.SECONDS.sleep(7);
			System.out.println("t3");
			return "TASK 3";
		});
		System.out.println(task1.get() + " " + task2.get() + " " + task3.get());
		System.out.println(Thread.currentThread().getName());
		fixPool.shutdown();
	}
}
