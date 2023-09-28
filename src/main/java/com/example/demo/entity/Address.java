package com.example.demo.entity;

import com.example.demo.Orders;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String house;
	@Pattern(regexp = "^\\d{6}$", message = "invalid number")
	String pin;
	@OneToOne(mappedBy = "address")
	Orders order;
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
}
