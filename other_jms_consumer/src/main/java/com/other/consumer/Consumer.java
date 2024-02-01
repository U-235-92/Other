package com.other.consumer;

import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

@MessageDriven(mappedName = "jms/other/example/destination/Topic")
public class Consumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if(message instanceof TextMessage) {
			TextMessage txtMessage = (TextMessage) message;
			try {
				System.out.println(txtMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
