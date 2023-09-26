package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.IOrderRepository;
import com.example.demo.Orders;
@Service
public class OrderService implements IOrderService {
	@Autowired
	IOrderRepository repository;
	public OrderService() {
		System.out.println("Order service bean initializing");
	}
	@Override
	public void saveOrder(Orders order) {
		order.setCratedDate(new Date());
		repository.save(order);
		System.out.println(order.getItem());
	}
	
}
