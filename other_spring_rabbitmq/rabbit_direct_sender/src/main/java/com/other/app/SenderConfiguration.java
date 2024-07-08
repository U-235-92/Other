package com.other.app;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfiguration {

	public static final String ORANGE_ROUTING_KEY = "orange";
	public static final String GREEN_ROUTING_KEY = "green";
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
	Exchange exchange() {
		DirectExchange exchange = new DirectExchange(EXCHANGE_NAME);
		return exchange;
	}
 }
