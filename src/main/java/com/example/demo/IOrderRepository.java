package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Orders, Integer>{
	Orders findByMobile(String mobile);
	Orders findByMobileAndEmail(String mobile, String email);
}
 