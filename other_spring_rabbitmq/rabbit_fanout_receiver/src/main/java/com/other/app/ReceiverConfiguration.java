package com.other.app;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReceiverConfiguration {
	
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
	Queue queue() {
		Queue queue = new Queue("spring_hello_queue_1");
		return queue;
	}
	
	@Bean
	FanoutExchange exchange() {
		FanoutExchange exchange = new FanoutExchange("my_spring_hello_exchange");
		return exchange;
	}
	
	@Bean
	Binding binding(Exchange exchange, Queue queue) {
		Binding binding = BindingBuilder.bind(queue).to(exchange).with("").noargs();
		return binding;
	}
	
//	@Bean
//	SimpleMessageListenerContainer simpleMessageListenerContainer() {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setQueueNames("spring_hello_queue");
//        container.setMessageListener(message -> System.out.println("Received: " + new String(message.getBody())));
//        return container;
//	}
}
