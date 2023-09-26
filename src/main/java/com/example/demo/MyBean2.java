package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("bean2")
public class MyBean2 implements IMyBean{

	@Override
	public void callme() {
		System.out.println("Mybean 2");
	}
	
}
