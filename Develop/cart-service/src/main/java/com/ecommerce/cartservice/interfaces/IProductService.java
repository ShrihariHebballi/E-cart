package com.ecommerce.cartservice.interfaces;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.ecommerce.cartservice.model.Product;
import com.sun.istack.NotNull;

@Validated
public interface IProductService {

	@NotNull
	Iterable<Product> getAllProducts();

	Product getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

	Product save(Product product);

	String delete(@Min(value = 1L, message = "Invalid product ID.") long id);
}
