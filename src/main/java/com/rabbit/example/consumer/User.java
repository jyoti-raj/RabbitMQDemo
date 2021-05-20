package com.rabbit.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbit.example.config.MessageConfig;
import com.rabbit.example.dto.OrderStatus;

@Component
public class User {

	@RabbitListener(queues = MessageConfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("message received from " + orderStatus);
	}
}
