package com.example.demo.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.example.demo.Orders;

public interface IOrderService {
	 void saveOrder(Orders order) throws IOException;
}
