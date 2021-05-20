package com.rabbit.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//order status sends at end user
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderStatus {

	private Order order;
	private String status;
	private String message;
}
