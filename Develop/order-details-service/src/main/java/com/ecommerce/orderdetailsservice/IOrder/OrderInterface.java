package com.ecommerce.orderdetailsservice.IOrder;

import com.ecommerce.orderdetailsservice.model.Order;

public interface OrderInterface {

	Iterable<Order> getAllOrders();
	
	String createOrder(Order order);
}
