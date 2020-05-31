package com.ecommerce.cartservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cartservice.model.Product;
import com.ecommerce.cartservice.service.ProductService;
import com.ecommerce.cartservice.service.ProductServiceImpl;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductServiceImpl productService) {
		this.productService = productService;
	}

	@GetMapping(value = { "", "/" })
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}
}
