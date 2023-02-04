package com.other.pattern.duck;

public interface QuackObservable {

	public void registerObserver(Observer observer);
	public void notifyObservers();
}
