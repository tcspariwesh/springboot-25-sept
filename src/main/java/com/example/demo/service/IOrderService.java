package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.Order;

public interface IOrderService {
	 void saveOrder(Order order);
}
