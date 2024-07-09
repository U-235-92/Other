package com.other.app;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConfiguration {

	private static final String ORANGE_ROUTING_KEY = "orange";
	private static final String GREEN_ROUTING_KEY = "green";
	public static final String EXCHANGE_NAME = "my_spring_direct_exchange";
	
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost("localhost");
		return connectionFactory;
	}
	
	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate();
		rabbitTemplate.setConnectionFactory(connectionFactory);
		return rabbitTemplate;
	}
	
	@Bean
	Queue queue() {
		return QueueBuilder.nonDurable().autoDelete().build();
	}
	
	@Bean
	Exchange exchange() {
		DirectExchange exchange = new DirectExchange(EXCHANGE_NAME);
		return exchange;
	}
	
	@Bean
	Binding binding(Queue queue, Exchange exchange) {
		Binding binding = BindingBuilder.bind(queue).to(exchange).with(ORANGE_ROUTING_KEY).noargs();
		return binding;
	}
	
	@Bean
	SimpleMessageListenerContainer listener(ConnectionFactory connectionFactory, Queue queue) {
		SimpleMessageListenerContainer listener = new SimpleMessageListenerContainer(connectionFactory);
		listener.addQueues(queue);
		listener.setMessageListener(message -> System.out.println("Received: " + new String(message.getBody())));
		return listener;
	}
 }
