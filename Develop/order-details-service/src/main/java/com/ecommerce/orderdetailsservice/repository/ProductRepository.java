package com.ecommerce.orderdetailsservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.orderdetailsservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
