package com.other.thread.phaser.test;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Fruit implements Runnable {

	private int weight;
	private String name;
	private Phaser phaser;
	private boolean waitBeforeRun;
	
	public Fruit(Phaser phaser, String name, boolean waitBeforeRun) {
		this.name = name;
		this.phaser = phaser;
		this.waitBeforeRun = waitBeforeRun;
		phaser.register();
	}
	
	@Override
	public void run() {
		firstPhase();
		secondPhase();
		thirdPhase();
		endPhase();
	}

	private void firstPhase() {
		synchronized(this) {
			while(waitBeforeRun) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		sleep(1);
		System.out.printf("%s в первой стадии роста! Текущий номер фазы = %d%n", name, phaser.getPhase());
		phaser.arriveAndAwaitAdvance();
		sleep(1);
	}
	
	private void secondPhase() {
		weight += (int) (1 +  (Math.random() * 10));
		System.out.printf("%s во второй стадии роста, его вес %d кг. Текущий номер фазы = %d%n", name, weight, phaser.getPhase());
		phaser.arriveAndAwaitAdvance();
		sleep(1);
	}
	
	private void thirdPhase() {
		weight += (int) (1 +  (Math.random() * 10));
		System.out.printf("%s в третей стадии роста, его вес %d кг. Текущий номер фазы = %d%n", name, weight, phaser.getPhase());
		phaser.arriveAndAwaitAdvance();
		sleep(1);
	}
	
	private void endPhase() {
		System.out.printf("%s созрел, забирай в корзинку%n", name);
		phaser.arriveAndDeregister();
	}
	
	private void sleep(int seconds) {
		try {
			int sleep = seconds * (int)(Math.random() * 3);
			TimeUnit.SECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void startGroving() {
		waitBeforeRun = false;
		notify();
	}
}
