package com.ecommerce.cartservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.cartservice.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
