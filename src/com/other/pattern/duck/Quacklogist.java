package com.other.pattern.duck;

public class Quacklogist implements Observer {

	@Override
	public void update(QuackObservable duck) {
		
		System.out.println("Quacklogist: " + duck + " just quacked.");
	}

}
