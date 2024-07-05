package com.other.rpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RPCServer {
	
	private static final String REMOTE_TASK_QUEUE = "remote_hello_task_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(REMOTE_TASK_QUEUE, false, false, false, null);
		DeliverCallback deliverCallback = (consumerTag, message) -> {
			System.out.println("The server accepted a message...");
			String greeting = greeting(new String(message.getBody()));
			channel.basicPublish("", message.getProperties().getReplyTo(), message.getProperties(), greeting.getBytes());
			channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
			System.out.println("The server processed a message");
		};
		channel.basicConsume(REMOTE_TASK_QUEUE, false, deliverCallback , consumerTag -> {});
	}
	
	private static String greeting(String name) {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello, " + name + "!";
	}
}
