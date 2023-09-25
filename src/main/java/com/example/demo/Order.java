package com.example.demo;

import jakarta.validation.constraints.NotBlank;

public class Order {
	@NotBlank
	String item;
	float price;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
