package com.other.hello;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class SenderMain {

	private static final String QUEUE_NAME = "HELLO_QUEUE";
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		try(Connection connection = connectionFactory.newConnection();
				Channel channel = connection.createChannel()) {
			int msgLimit = 50;
			while(msgLimit != 0) {
				String payload = "Hello, rabbitMQ! " + msgLimit;
				channel.queueDeclare(QUEUE_NAME, false, false, false, null);
				channel.basicPublish("", QUEUE_NAME, null, payload.getBytes());
				msgLimit--;
			}
			System.out.println("The messages were send");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
