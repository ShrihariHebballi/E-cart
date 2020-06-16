package com.ecommerce.productservice.interfaces;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.ecommerce.productservice.model.Product;
import com.sun.istack.NotNull;

@Validated
public interface ProductInterface {

	@NotNull
	Iterable<Product> getAllProducts();

	Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

	ResponseEntity<Product> save(Product product);

	ResponseEntity<String> delete(@Min(value = 1L, message = "Invalid product ID.") long id);
}
