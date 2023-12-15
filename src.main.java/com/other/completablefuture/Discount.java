package com.other.completablefuture;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public enum Discount {
	NONE(0), SILVER(5), GOLD(10), PLATINUM(15);

	private int percentage;
	
	Discount(int percentage) {
		this.percentage = percentage;
	}

	public int getPercentage() {
		return percentage;
	}
	
	public static String applyDiscount(Quote quote) {
		return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
	}
	
	private static double apply(double price, Discount discount) {
		delay();
		return price * (100 - discount.getPercentage()) / 100;
	}

	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep((new Random().nextInt(3)));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
