package com.ecommerce.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.productservice.interfaces.ProductInterface;
import com.ecommerce.productservice.model.Product;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/api/products")
public class ApplicationController {

	@Autowired
	private ProductInterface productService;

	@RequestMapping(method = RequestMethod.GET, value = { "", "/all" }, produces = "application/json")
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(method = RequestMethod.POST, value = { "", "/save" }, produces = "application/json")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@RequestMapping(method = RequestMethod.GET, value = { "", "/byid" }, produces = "application/json")
	public Product getProduct(@RequestHeader Long id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = { "", "/delete" }, produces = "application/json")
	public ResponseEntity<String> deleteProduct(@RequestHeader Long id) {
		return productService.delete(id);
	}
}
