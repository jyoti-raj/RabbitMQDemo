package com.rabbit.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

	//data that to be inserted/publish to queue
	private String orderId;
	private String name;
	private int qty;
	private double price;
}
