package com.other.flowAPI.simple_subscriber_publisher;

import java.util.concurrent.Flow.Publisher;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getTemperatures("New York").subscribe(new TempSubscriber());
		getCelsiusTemeratures("Berlin").subscribe(new TempSubscriber());
	}
	
	private static Publisher<TempInfo> getTemperatures(String town) {
		return subscriber -> subscriber.onSubscribe(new TempSubsciption(subscriber, town));
	}
	
	public static Publisher<TempInfo> getCelsiusTemeratures(String town) {
		return subscriber -> {
			TempProcessor processor = new TempProcessor();
			processor.subscribe(subscriber);
			processor.onSubscribe(new TempSubsciption(processor, town));
		};
	}
}
