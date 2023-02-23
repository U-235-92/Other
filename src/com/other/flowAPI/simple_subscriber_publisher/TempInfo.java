package com.other.flowAPI.simple_subscriber_publisher;

import java.util.Random;

public class TempInfo {

	public static final Random RANDOM = new Random();
	
	private final String town;
	private final int temp;
	
	public TempInfo(String town, int temp) {
		super();
		this.town = town;
		this.temp = temp;
	}
	
	public static TempInfo fetch(String town) {
		if(RANDOM.nextInt(10) == 0) {
			throw new RuntimeException();
		}
		return new TempInfo(town, RANDOM.nextInt(100));
	}
	
	@Override
	public String toString() {
		return town + " : " + temp;
	}

	public String getTown() {
		return town;
	}

	public int getTemp() {
		return temp;
	}
}
