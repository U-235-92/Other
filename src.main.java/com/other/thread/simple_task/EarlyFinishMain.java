package com.other.thread.simple_task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class EarlyFinishMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService serv = Executors.newFixedThreadPool(1);
		Future<String> futureResult = serv.submit(() -> {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("FUTURE");
			return "FUTURE";
		});
		System.out.println(Thread.currentThread().getName());
		serv.shutdown();
	}

}
