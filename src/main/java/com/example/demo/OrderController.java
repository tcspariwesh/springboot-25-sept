package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {//singleton
	@PostMapping("/order")
	void createOrder() {
		System.out.println("created");
	}
}
