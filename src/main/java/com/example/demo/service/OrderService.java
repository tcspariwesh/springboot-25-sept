package com.example.demo.service;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.IOrderRepository;
import com.example.demo.Orders;
@Service
public class OrderService implements IOrderService {
	@Autowired
	IOrderRepository repository;
	Logger logger  = LoggerFactory.getLogger(getClass());
	public OrderService() {
		System.out.println("Order service bean initializing");
	}
	@Override
	@Transactional(rollbackFor = {Exception.class}, noRollbackFor = {IOException.class})
	public void saveOrder(Orders order) throws IOException {
		order.setCratedDate(new Date());
		repository.save(order);
		System.out.println(order.getItem());
		if(1==1)
			throw new IOException("something went wrong");
		logger.debug("saved successfully");
		//db operation
	}
}
