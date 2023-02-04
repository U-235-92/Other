package com.other.thread.dead_lock;

public class User {

	private int balance;
	private String name;
	
	public User(String name, int balance) {
		this.balance = balance;
		this.name = name;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
