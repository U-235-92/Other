package com.other.xml_test;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "car_shop")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarShop {

	@XmlAttribute(name = "shop_name")
	private String shopName;
	@XmlAttribute(name =  "shop_phone")
	private String shopPhone;
	@XmlElementWrapper(name = "cars")
	@XmlElement(name = "car")
	private List<Car> cars;
	
	public CarShop() {
		super();
	}

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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("shop name=");
		sb.append(shopName);
		sb.append(" ");
		sb.append("phone=");
		sb.append(shopPhone);
		sb.append(cars);
		return sb.toString();
	}
}
