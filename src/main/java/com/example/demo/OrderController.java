package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IOrderService;

import jakarta.validation.Valid;

@RestController //Bean
public class OrderController {//singleton, dependent
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IOrderService orderService;  //inject
	@Autowired
	IMyBean bean;
	@PostMapping("/order")
	@ResponseStatus(code = HttpStatus.CREATED)
	void createOrder(@Valid @RequestBody Orders order) {
		logger.info(order.getItem());
		try {
			orderService.saveOrder(order);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bean.callme();
	}
	@GetMapping("/order")
	List<Orders> getOrders(){
		return null;
	}
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception){
		Map<String , String> errorMessages = new HashMap<>();
		List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
		allErrors.forEach((error) -> {
			FieldError fieldError = ((FieldError) error);
			String fieldName = fieldError.getField();
			String errorMessage = fieldError.getDefaultMessage();
			errorMessages.put(fieldName, errorMessage);
		});
		return errorMessages;
	}
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	String handleAllexceptions(Exception ex){
		return ex.getMessage();
	}
}
