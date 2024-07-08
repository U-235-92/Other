package com.other.app;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConfiguration {
	
	@Bean 
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost("localhost");
		return connectionFactory;
	}
	
	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		return template;
	}
	
	@Bean
	FanoutExchange exchange() {
		FanoutExchange exchange = new FanoutExchange("my_spring_hello_exchange");
		return exchange;
	}
	
	@Bean
	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
		return rabbitAdmin;
	}
	
//	@Bean
//	Queue queue() {
//		Queue queue = new Queue("spring_hello_queue");
//		return queue;
//	}
//	
//	@Bean
//	Binding binding(Exchange exchange, Queue queue) {
//		Binding binding = BindingBuilder.bind(queue).to(exchange).with("").noargs();
//		return binding;
//	}
}
