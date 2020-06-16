package com.ecommerce.cartservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.cartservice.model.OrderProduct;
import com.ecommerce.cartservice.model.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
