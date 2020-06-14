package com.ecommerce.orderdetailsservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.orderdetailsservice.model.OrderProduct;
import com.ecommerce.orderdetailsservice.model.OrderProductPK;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK> {
}
