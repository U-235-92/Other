package com.other.thread.common_counter;

public class Main {

	public static void main(String[] args) {
		CommonCounter commonCounter = new CommonCounter();
		Runnable r1 = () -> {
			commonCounter.countASC();
		};
		Runnable r2 = () -> {
			commonCounter.countDESC();
		};	
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
