package com.other.thread.ex;

import java.util.concurrent.CountDownLatch;

class MyThread implements Runnable {
	String name;
	CountDownLatch cdl;
	
	public MyThread(CountDownLatch cdl, String name) {
		this.cdl = cdl;
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5;  i++) {
			System.out.println(name + ": " + i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			cdl.countDown();
		}
	}
}