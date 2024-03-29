package com.other.pattern.duck;

public class QuackCounter implements Quackable {

	private Observable observable;
	
	private Quackable duck;
	
	private static int numberOfQuacks;
	
	public QuackCounter(Quackable duck) {
		
		this.duck = duck;
		
		observable = new Observable(this);
	}
	
	@Override
	public void quack() {
		
		duck.quack();
		notifyObservers();
		numberOfQuacks++;
	}
	
	public static int getQuacks() {
		
		return numberOfQuacks;
	}

	@Override
	public void registerObserver(Observer observer) {
		
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		
		observable.notifyObservers();
	}

}
