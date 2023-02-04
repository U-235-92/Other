package com.other.decorator;

import com.other.decorator.Beverage.Size;

public class Main {

	public static void main(String[] args) {
		
		Beverage beverage1 = new Espresso(Size.TALL);
		beverage1 = new Mocha(beverage1);
		beverage1 = new Mocha(beverage1);
		beverage1 = new Whip(beverage1);
		
		System.out.println(beverage1.getDescription() + beverage1.cost());
		
		Beverage beverage2 = new Espresso(Size.GRANDE);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		
		System.out.println(beverage2.getDescription() + beverage2.cost());
	}
}
