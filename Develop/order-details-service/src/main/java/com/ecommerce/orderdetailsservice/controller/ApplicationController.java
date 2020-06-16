package com.ecommerce.orderdetailsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.orderdetailsservice.IOrder.OrderInterface;
import com.ecommerce.orderdetailsservice.model.Order;
import com.ecommerce.orderdetailsservice.model.OrderForm;

@RestController
@RequestMapping("/api/orders")
public class ApplicationController {

	@Autowired
	private OrderInterface orderInterface;

	@RequestMapping(value = { "", "/all" }, method = RequestMethod.GET)
	public Iterable<Order> list() {
		return orderInterface.getAllOrders();
	}

	@RequestMapping(value = { "", "/create" }, method = RequestMethod.POST)
	public ResponseEntity<Order> create(@RequestBody OrderForm form) {
		return orderInterface.createOrder(form);
	}

}
