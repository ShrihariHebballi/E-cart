package com.ecommerce.orderdetailsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.orderdetailsservice.IOrder.OrderInterface;
import com.ecommerce.orderdetailsservice.model.Order;
import com.ecommerce.orderdetailsservice.repository.OrderRepository;

@Service
@Transactional
public class OrderService implements OrderInterface {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public String createOrder(Order order) {
		return null;
	}

}
