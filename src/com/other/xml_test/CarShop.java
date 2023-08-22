package com.other.xml_test;

import java.util.List;

public class CarShop {

	private String shopName;
	private String shopPhone;
	private List<Car> cars;
	
	public CarShop(String shopName, String shopPhone, List<Car> cars) {
		super();
		this.shopName = shopName;
		this.shopPhone = shopPhone;
		this.cars = cars;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
