package com.other.pattern.duck;

public class DuckSimulator {

	public static void main(String[] args) {
	
		DuckSimulator simulator = new DuckSimulator();
		
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		
		simulator.simulate(duckFactory);
	}
	
	private void simulate(AbstractDuckFactory duckFactory) {
		
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable goosDuck = new GooseAdapter(new Goose());
		
		Flock flockOfDucks = new Flock();
		
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(mallardDuck);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(goosDuck);
		flockOfDucks.add(duckCall);
		
		Flock flockOfMallards = new Flock();
		
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();
		
		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);
		
		flockOfMallards.add(flockOfDucks);
		
//		System.out.println("\nDuck Simulator: Whole Flock Simulation: ");
//		simulate(flockOfDucks);
//		
//		System.out.println("\nDuck Simulator: Mallard Flock Simulation: ");
//		simulate(flockOfMallards);
		
		System.out.println("\nDuck Simulator: Whole Observer: ");
		Quacklogist quacklogist = new Quacklogist();
		flockOfMallards.registerObserver(quacklogist);
		
		simulate(flockOfMallards);
		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
	}
	
	private void simulate(Quackable duck) {
		
		duck.quack();
	}
}
