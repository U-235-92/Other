package com.other.app;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConfiguration {

	private String exchangeName = "my_spring_topic_exchange";
	
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost("localhost");
		return connectionFactory;
	}
	
	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}
	
	@Bean
	TopicExchange exchange() {
		TopicExchange exchange = new TopicExchange(exchangeName);
		return exchange;
	}
	
	@Bean
	Queue queue1() {
		Queue queue = new Queue("spring_topic_queue1");
		return queue;
	}
	
	@Bean
	Queue queue2() {
		Queue queue = new Queue("spring_topic_queue2");
		return queue;
	}
	
	@Bean 
	Binding binding1(TopicExchange exchange, Queue queue1) {
		Binding binding = BindingBuilder.bind(queue1).to(exchange).with("car.#");
		return binding;
	}
	
	@Bean 
	Binding binding2(TopicExchange exchange, Queue queue2) {
		Binding binding = BindingBuilder.bind(queue2).to(exchange).with("car.yellow.*");
		return binding;
	}
}
