package com.other.decorator;

public class Soy extends CondimentDecorator {

	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		
		return beverage.getDescription() + "Soy";
	}

	@Override
	public double cost() {
		
		double cost = beverage.cost();
		
		if(beverage.getSize() == Size.TALL) {
			
			cost += .8;
		} else if(beverage.getSize() == Size.GRANDE) {
			
			cost += .11;
		} else if(beverage.getSize() == Size.VENTI)  {
			
			cost += .14;
		}
		
		return cost;
	}

}
