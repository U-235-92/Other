package com.other.hello;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;

public class ReceiverMain {

	private static final String QUEUE_NAME = "HELLO_QUEUE";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.basicQos(1);
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		DeliverCallback deliveryCallback = (consumerTag, message) -> {
			System.out.println("Recieive message: " + new String(message.getBody()));
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
		};
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME, autoAck, deliveryCallback, consumerTag -> {});
	}

}
