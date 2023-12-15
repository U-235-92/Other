package com.other.completablefuture;

public class Quote {

	private final String shopName;
	private final double price;
	private final Discount discountCode;
	
	public Quote(String shopName, double price, Discount discountCode) {
		super();
		this.shopName = shopName;
		this.price = price;
		this.discountCode = discountCode;
	}
	
	public static Quote parse(String str) {
		String[] split = str.split(":");
		String shopName = split[0];
		double price = Double.valueOf(split[1]);
		Discount discountCode = Discount.valueOf(split[2]);
		return new Quote(shopName, price, discountCode);
	}

	public String getShopName() {
		return shopName;
	}

	public double getPrice() {
		return price;
	}

	public Discount getDiscountCode() {
		return discountCode;
	}
}
