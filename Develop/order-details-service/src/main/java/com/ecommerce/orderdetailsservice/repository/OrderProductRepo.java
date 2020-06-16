package com.ecommerce.orderdetailsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.orderdetailsservice.model.OrderProduct;
import com.ecommerce.orderdetailsservice.model.OrderProductKey;

public interface OrderProductRepo extends JpaRepository<OrderProduct, OrderProductKey> {

}
