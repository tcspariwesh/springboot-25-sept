package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IOrderService;

import jakarta.validation.Valid;

@RequestMapping("/order")
@RestController // Bean
public class OrderController {// singleton, dependent

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	IOrderService orderService; // inject
	@Autowired
	IMyBean bean;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	void createOrder(@Valid @RequestBody Orders order) {
		logger.info(order.getItem());
		orderService.saveOrder(order);
//		bean.callme();
	}

	@GetMapping
	List<Orders> getOrders() {
		return orderService.getOrders();
	}

	@GetMapping("/{id}")
	ResponseEntity<Orders> getOrders(@PathVariable Integer id) {
		Orders order = orderService.getOrders(id);
		ResponseEntity<Orders> responseEntity;
		if (order == null) {
//			logger.debug(order);
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			responseEntity = new ResponseEntity<>(order, HttpStatus.OK);
		}
		return responseEntity;
	}

	@GetMapping("/mobile/{mobile}")
	Orders getOrdersByMobile(@PathVariable String mobile) {
		return orderService.getOrdersByMobile(mobile);
	}

	@DeleteMapping("/{id}")
	void deleteOrders(@PathVariable Integer id) {
		orderService.deleteOrders(id);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {
		Map<String, String> errorMessages = new HashMap<>();
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
	String handleAllexceptions(Exception ex) {
		ex.printStackTrace();
		return ex.getMessage();
	}
}
