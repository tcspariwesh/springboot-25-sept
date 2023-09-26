package com.example.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IOrderService;
import com.example.demo.service.OrderService;

import jakarta.validation.Valid;

@RestController //Bean
public class OrderController {//singleton, dependent
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IOrderService orderService;  //inject
	@Autowired
	IMyBean bean;
	@PostMapping("/order")
	void createOrder(@Valid @RequestBody Orders order) {
		logger.info(order.getItem());
		orderService.saveOrder(order);
		bean.callme();
	}
	@GetMapping("/order")
	List<Orders> getOrders(){
		return null;
	}
}
