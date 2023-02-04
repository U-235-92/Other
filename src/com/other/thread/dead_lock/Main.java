package com.other.thread.dead_lock;

public class Main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		User ivan = new User("Ivan", 1000);
		User fedor = new User("Fedor", 5000);
		Runnable r1 = () -> {
			bank.transfer(fedor, ivan, 6000);
		};
		Runnable r2 = () -> {
			bank.transfer(ivan, fedor, 2000);
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
