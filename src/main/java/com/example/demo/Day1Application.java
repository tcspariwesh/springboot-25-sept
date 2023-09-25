package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Day1Application.class, args); //spring container = java object
		//bean,ddd
		OrderController controller= context.getBean(OrderController.class);
		System.out.println(controller);
//		controller.createOrder(); //never
	}

}
