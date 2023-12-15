package com.other.flowAPI.simple_subscriber_publisher;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TempSubscriber implements Subscriber<TempInfo> {
	
	private Subscription subscription;

	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		this.subscription = subscription;
		subscription.request(1);
	}

	@Override
	public void onNext(TempInfo tempInfo) {
		// TODO Auto-generated method stub
		System.out.println(tempInfo);
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		System.err.println(throwable.getMessage());
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("Done!");
	}
	
	
}
