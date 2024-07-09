package com.other.app;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HeaderReceiver {

	@RabbitListener(queues = "germany_queue")
	public void receiveGermany(Message message) {
		System.out.println("Recived: " + new String(message.getBody()));
	}
	
	@RabbitListener(queues = "japan_queue")
	public void receiveJapan(Message message) {
		System.out.println("Recived: " + new String(message.getBody()));
	}
	
	@RabbitListener(queues = "russia_queue")
	public void receiveRussia(Message message) {
		System.out.println("Recived: " + new String(message.getBody()));
	}
}
