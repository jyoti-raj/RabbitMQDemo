package com.rabbit.example.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rabbit.example.config.MessageConfig;
import com.rabbit.example.dto.Order;
import com.rabbit.example.dto.OrderStatus;


@RestController
@RequestMapping("/order")
public class OrderPublish {

	//injection of rabbitMQ
	@Autowired
	public RabbitTemplate template;
	
	@PostMapping("/{restaurentName}")
	public String bookOrder(@RequestBody Order order,@PathVariable String restaurentName) {
		order.setOrderId(UUID.randomUUID().toString());
		 OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurentName);
		template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY,orderStatus);
		return "Success!!";
	}
}
