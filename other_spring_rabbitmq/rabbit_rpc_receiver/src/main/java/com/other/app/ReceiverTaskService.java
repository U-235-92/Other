package com.other.app;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiverTaskService {

	@Autowired
	private RabbitTemplate template;
	
	@RabbitListener(queues = "rpc_task_queue")
	public void printMessage(String name) {
		System.out.println(name);
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		template.convertAndSend("answer", "Hello " + name + "!");
	}
}
