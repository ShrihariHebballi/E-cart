package com.ecommerce.cartservice.service;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.ecommerce.cartservice.model.Product;
import com.sun.istack.NotNull;

@Validated
public interface ProductService {

	@NotNull
	Iterable<Product> getAllProducts();

	Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

	Product save(Product product);
}
