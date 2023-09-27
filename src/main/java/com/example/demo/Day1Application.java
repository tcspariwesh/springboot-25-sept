package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // meta-annotation
public class Day1Application {

	public static void main(String[] args) {
		String s1 = new String("test");
		ApplicationContext context = SpringApplication.run(Day1Application.class, args); // spring container = java
																							// object
		// bean
		OrderController controller = context.getBean(OrderController.class);
//		System.out.println("count##=" + context.isSingleton(s1));
		System.out.println(controller);
//		controller.createOrder(); //never
	}
}
