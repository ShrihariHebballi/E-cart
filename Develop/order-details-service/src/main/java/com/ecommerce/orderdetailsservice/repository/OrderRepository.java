package com.ecommerce.orderdetailsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.orderdetailsservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
