package com.ecommerce.cartservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.cartservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
