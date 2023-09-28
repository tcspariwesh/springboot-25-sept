package com.example.demo.service;

import java.util.List;

import com.example.demo.Orders;

public interface IOrderService {
	void saveOrder(Orders order);

	List<Orders> getOrders();

	Orders getOrders(Integer id);

	void deleteOrders(Integer id);

	Orders getOrdersByMobile(String mobile);
}
