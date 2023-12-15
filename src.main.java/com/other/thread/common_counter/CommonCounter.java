package com.other.thread.common_counter;

import java.util.concurrent.TimeUnit;

public class CommonCounter {

	public synchronized void countASC() {
		try {
			int count = 5;
			while(count > 0) {
				System.out.printf("%s, count: %d%n", Thread.currentThread().getName(), count--);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch(InterruptedException e) {
			System.out.printf("%s interrupted!%n", Thread.currentThread().getName());
		}
	}
	
	public synchronized void countDESC() {
		try {
			int count = 0;
			while(count-- > -5) {
				System.out.printf("%s, count: %d%n", Thread.currentThread().getName(), count);
				TimeUnit.SECONDS.sleep(1);
			}
		} catch(InterruptedException e) {
			System.out.printf("%s interrupted!%n", Thread.currentThread().getName());
		}
	}
}
