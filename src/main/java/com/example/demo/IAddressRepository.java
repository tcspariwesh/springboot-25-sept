package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer>{

}
