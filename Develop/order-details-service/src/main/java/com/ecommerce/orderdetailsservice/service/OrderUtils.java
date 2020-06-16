package com.ecommerce.orderdetailsservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.orderdetailsservice.model.Order;
import com.ecommerce.orderdetailsservice.model.OrderProduct;
import com.ecommerce.orderdetailsservice.repository.OrderProductRepo;
import com.ecommerce.orderdetailsservice.repository.OrderRepository;

@Transactional
@Component
public class OrderUtils {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderProductRepo oPRepo;

	public Iterable<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order persistOrder(Order order) {
		return orderRepository.save(order);
	}

	public List<OrderProduct> persistOrderProduct(List<OrderProduct> orderProduct) {
		return oPRepo.saveAll(orderProduct);
	}
}
