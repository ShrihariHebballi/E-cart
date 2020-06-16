package com.ecommerce.orderdetailsservice.IOrder;

import org.springframework.http.ResponseEntity;

import com.ecommerce.orderdetailsservice.model.Order;
import com.ecommerce.orderdetailsservice.model.OrderForm;

public interface OrderInterface {

	public Iterable<Order> getAllOrders();

	public ResponseEntity<Order> createOrder(OrderForm form);
}
