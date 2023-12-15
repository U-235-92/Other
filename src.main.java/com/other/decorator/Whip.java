package com.other.decorator;

public class Whip extends CondimentDecorator {

	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		
		return beverage.getDescription() + "Whip";
	}

	@Override
	public double cost() {
		
		double cost = beverage.cost();
		
		if(beverage.getSize() == Size.TALL) {
			
			cost += .12;
		} else if(beverage.getSize() == Size.GRANDE) {
			
			cost += .17;
		} else if(beverage.getSize() == Size.VENTI)  {
			
			cost += .22;
		}
		
		return cost;
	}
}
