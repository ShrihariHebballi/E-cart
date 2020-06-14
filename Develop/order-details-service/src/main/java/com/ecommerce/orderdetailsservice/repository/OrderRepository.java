package com.ecommerce.orderdetailsservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.orderdetailsservice.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
