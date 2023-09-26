package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //bean
public class ProjectConfiguration {
	@Value("com.example.flag")
	String flag;

	@Bean
	IMyBean createMyBean() {
		System.out.println("creating MyBean instance");
		if (flag.equals("1"))
			return new MyBean();
		else
			return new MyBean2();
	}
}
