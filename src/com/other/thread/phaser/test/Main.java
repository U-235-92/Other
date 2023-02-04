package com.other.thread.phaser.test;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);
		Fruit orange = new Fruit(phaser, "Апельсин", true);
		Fruit apple = new Fruit(phaser, "Яблоко", true);
		Fruit pineapple = new Fruit(phaser, "Ананас", true);
		Thread orangeThread = new Thread(orange);
		Thread appleThread = new Thread(apple);
		Thread pineappleThread = new Thread(pineapple);
		orangeThread.start();
		appleThread.start();
		pineappleThread.start();
		
		System.out.println("Вспахали грядку, посадили фрукты, ждем, как они вырастут\n");
		orange.startGroving();
		apple.startGroving();
		pineapple.startGroving();
				
		int currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%d завершена%n%n", currentPhase);
//		sleep(500);
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%d завершена%n%n", currentPhase);
//		sleep(500);
		
		currentPhase = phaser.getPhase();
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%d завершена%n%n", currentPhase);
//		sleep(500);
		
		try {
			appleThread.join();
			orangeThread.join();
			pineappleThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Все фрукты созрели, урожай собран");
	}

	private static void sleep(int mills) {
		try {
			TimeUnit.MILLISECONDS.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
