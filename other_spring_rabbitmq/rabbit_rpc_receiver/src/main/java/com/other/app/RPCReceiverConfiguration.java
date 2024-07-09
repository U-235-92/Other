package com.other.app;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RPCReceiverConfiguration {
	
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost("localhost");
		return connectionFactory;
	}
	
	@Bean
	DirectExchange directExchange() {
		DirectExchange directExchange = new DirectExchange("my_spring_rpc_exchange");
		return directExchange;
	}
	
	@Bean
	RabbitTemplate template(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setExchange(directExchange().getName());
		return template;
	}
	
	@Bean
	Queue taskQueue() {
		Queue queue = new Queue("rpc_task_queue");
		return queue;
	}
	
	@Bean
	Queue answerQueue() {
		Queue queue = new Queue("rpc_answer_queue");
		return queue;
	}
	
	@Bean
	Binding taskBinding(DirectExchange directExchange, Queue taskQueue) {
		Binding binding = BindingBuilder.bind(taskQueue).to(directExchange).with("task");
		return binding;
	}
	
	@Bean
	Binding answerBinding(DirectExchange directExchange, Queue answerQueue) {
		Binding binding = BindingBuilder.bind(answerQueue).to(directExchange).with("answer");
		return binding;
	}
}
