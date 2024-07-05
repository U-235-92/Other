package com.other.rpc;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RPCClient {

	private static final String REQUEST_QUEUE = "remote_hello_task_queue";
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		try {
			Connection connection = connectionFactory.newConnection();
			Channel channel = connection.createChannel();
			String correlationID = UUID.randomUUID().toString();
			String responseQueue = channel.queueDeclare().getQueue();
			BasicProperties messageBasicProperties = new BasicProperties.
					Builder().
					correlationId(correlationID).
					replyTo(responseQueue).
					build();
			channel.basicPublish("", REQUEST_QUEUE, messageBasicProperties, args[0].getBytes());
			CompletableFuture<String> rpcResponseFuture = new CompletableFuture<String>();
			DeliverCallback delverCallback = (consumerTag, message) -> {
				if(message.getProperties().getCorrelationId().equals(correlationID)) {					
					rpcResponseFuture.complete(new String(message.getBody()));
				}
			};
			channel.basicConsume(responseQueue, false, delverCallback , consumerTag -> {});
			String rpcResponseResult = rpcResponseFuture.get();
			System.out.println("RPC Response: " + rpcResponseResult);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
