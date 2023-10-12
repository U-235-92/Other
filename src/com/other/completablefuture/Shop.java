package com.other.completablefuture;

import java.util.concurrent.TimeUnit;

public class Shop {

	private String name;
	
	public Shop(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPriceFor(String product) {
		delay();
		return Math.random() * 1000;
	}
	
	private void delay() {
		try {
			TimeUnit.SECONDS.sleep((int) (1 + Math.random() * 3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
