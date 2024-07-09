package com.other.app;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
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
	HeadersExchange exchange() {
		return ExchangeBuilder.headersExchange("my_spring_header_exchange").build();
	}
	
	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Exchange exchange) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setExchange(exchange.getName());
		return rabbitTemplate;
	}
	
	@Bean
	Queue queueGermany() {
		return QueueBuilder.nonDurable("germany_queue").autoDelete().build();
	}
	
	@Bean
	Queue queueJapan() {
		return QueueBuilder.nonDurable("japan_queue").autoDelete().build();
	}
	
	@Bean
	Queue queueRussia() {
		return QueueBuilder.nonDurable("russia_queue").autoDelete().build();
	}
	
	@Bean
	Binding bindingGermany(HeadersExchange exchange, Queue queueGermany) {
		Binding binding = BindingBuilder.bind(queueGermany).to(exchange).where("country").matches("Germany");
		return binding;
	}
	
	@Bean
	Binding bindingJapan(HeadersExchange exchange, Queue queueJapan) {
		Binding binding = BindingBuilder.bind(queueJapan).to(exchange).where("country").matches("Japan");
		return binding;
	}
	
	@Bean
	Binding bindingRussia(HeadersExchange exchange, Queue queueRussia) {
		Binding binding = BindingBuilder.bind(queueRussia).to(exchange).where("country").matches("Russia");
		return binding;
	}
}
