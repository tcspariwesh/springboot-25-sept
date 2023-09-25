package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Order;
@Service
public class OrderService implements IOrderService {

	@Override
	public void saveOrder(Order order) {
		System.out.println(order.getItem());
	}

}
