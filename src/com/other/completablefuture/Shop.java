package com.other.completablefuture;

import java.util.Random;
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
	
	public String getDiscountPrice(String product) {
		double price = getPriceFor(product);
		Discount code = Discount.values()[new Random().nextInt(Discount.values().length)];
//		return String.format("%s:%.2f:%s", name, price, code);
		return new String(name + ":" + price + ":" + code);
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
