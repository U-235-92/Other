package com.other.thread.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		CountDownLatch cdl1 = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		System.out.println("Start!");
		es.execute(new Main().new MyThread(cdl1, "A"));
		es.execute(new Main().new MyThread(cdl2, "B"));
		es.execute(new Main().new MyThread(cdl3, "C"));
		es.execute(new Main().new MyThread(cdl4, "D"));
		try {
			cdl1.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("Stop!");
		
	}
	
	private class MyThread implements Runnable {
		private CountDownLatch cdl;
		private String name;
		
		public MyThread(CountDownLatch cdl, String name) {
			this.cdl = cdl;
			this.name = name;
		}
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.printf("%s: %d%n", name, i);
				sleep(50);
				cdl.countDown();
			}
		}
		private void sleep(int mills) {
			// TODO Auto-generated method stub
			try {
				TimeUnit.MILLISECONDS.sleep(mills);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
