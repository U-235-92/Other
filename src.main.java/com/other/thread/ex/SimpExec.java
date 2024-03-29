package com.other.thread.ex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch cdl = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);
		System.out.println("Start!");
		es.execute(new MyThread(cdl, "A"));
		es.execute(new MyThread(cdl, "B"));
		es.execute(new MyThread(cdl, "C"));
		es.execute(new MyThread(cdl, "D"));
		try {
			cdl.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("End!");
	}
}
