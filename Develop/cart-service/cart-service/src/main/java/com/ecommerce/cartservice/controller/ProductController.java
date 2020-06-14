package com.ecommerce.cartservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cartservice.interfaces.IProductService;
import com.ecommerce.cartservice.model.Product;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping(method = RequestMethod.GET, value = { "", "/all" }, produces = "application/json")
	public @NotNull Iterable<Product> getProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(method = RequestMethod.POST, value = { "", "/save" }, produces = "application/json")
	public Product saveProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@RequestMapping(method = RequestMethod.GET, value = { "", "/byid" }, produces = "application/json")
	public Product getProduct(@RequestHeader Long id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = { "", "/delete" }, produces = "application/json")
	public String deleteProduct(@RequestHeader Long id) {
		return productService.delete(id);
	}
}
