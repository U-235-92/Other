package com.other.pattern.duck;

import java.util.ArrayList;
import java.util.Iterator;

public class Flock implements Quackable {

	private Observable observable;
	
	private ArrayList<Quackable> quackers = new ArrayList<>();
	
	public Flock() {
		
		observable = new Observable(this);
	}
	
	public void add(Quackable quacker) {
		
		quackers.add(quacker);
	}
	
	@Override
	public void quack() {
		
		Iterator<Quackable> iterator = quackers.iterator();
		
		while(iterator.hasNext()) {
			
			Quackable quacker = iterator.next();
			quacker.quack();
			notifyObservers();
		}
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
