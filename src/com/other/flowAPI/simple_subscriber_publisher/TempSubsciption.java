package com.other.flowAPI.simple_subscriber_publisher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TempSubsciption implements Subscription {

	private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(1, run -> {
		Thread t = new Thread(run);
		t.setDaemon(true);
		return t;
	});
	private final Subscriber<? super TempInfo> subscriber;
	private final String town;
	
	
	public TempSubsciption(Subscriber<? super TempInfo> subscriber, String town) {
		super();
		this.subscriber = subscriber;
		this.town = town;
	}

	@Override
	public void request(long n) {
		// TODO Auto-generated method stub
		EXECUTOR.submit(() -> {
			for (long i = 0; i < n; i++) {
				try {
					subscriber.onNext(TempInfo.fetch(town));
				} catch(Exception ex) {
					subscriber.onError(ex);
					break;
				}
			}
		});
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		subscriber.onComplete();
	}

}
