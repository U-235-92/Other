package com.other.thread.comp_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->  {
			try {
				for(int i = 0; i < 3; i++) {
					System.out.println(Thread.currentThread().getName() + ": " + i);
					TimeUnit.SECONDS.sleep(1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("End of supply");
			return "Hi";
		});
		completableFuture.thenAccept(t -> System.out.println("Accept, " + t)).thenAccept(t -> System.out.println("Other, " + t));
		try {
			completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
