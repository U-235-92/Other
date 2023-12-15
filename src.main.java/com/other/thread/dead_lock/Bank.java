package com.other.thread.dead_lock;

import java.util.concurrent.TimeUnit;

public class Bank {

	public synchronized void transfer(User from, User to, int payment) {
		try {
			System.out.printf("Try transfer %d from %s to %s%n", payment, from, to);
			TimeUnit.SECONDS.sleep(1);
			while(from.getBalance() < payment) {
				wait();
			}
			to.setBalance(to.getBalance() + payment);
			from.setBalance(from.getBalance() - payment);
			System.out.printf("Success transfer %d from %s to %s%n", payment, from, to);
			notifyAll();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
