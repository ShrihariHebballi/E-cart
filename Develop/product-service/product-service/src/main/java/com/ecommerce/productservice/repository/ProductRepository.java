package com.ecommerce.productservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.productservice.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
