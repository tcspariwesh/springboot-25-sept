package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service
@Qualifier("bean1")
public class MyBean implements IMyBean{
	public void callme(){
		System.out.println("Bean 1 ####");
	}
}
