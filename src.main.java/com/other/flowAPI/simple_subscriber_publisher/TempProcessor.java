package com.other.flowAPI.simple_subscriber_publisher;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TempProcessor implements Processor<TempInfo, TempInfo> {

	private Subscriber<? super TempInfo> subscriber;
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		subscriber.onSubscribe(subscription);
	}

	@Override
	public void onNext(TempInfo item) {
		// TODO Auto-generated method stub
		subscriber.onNext(new TempInfo(item.getTown(), (item.getTemp() - 32) * 5 / 9));
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		subscriber.onError(throwable);
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		subscriber.onComplete();
	}

	@Override
	public void subscribe(Subscriber<? super TempInfo> subscriber) {
		// TODO Auto-generated method stub
		this.subscriber = subscriber;
	}

}
