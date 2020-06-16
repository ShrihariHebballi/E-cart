package com.ecommerce.orderdetailsservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecommerce.orderdetailsservice.model.Product;

@FeignClient(name = "cart-service", url = "http://localhost:8081")
public interface CartService {

	@RequestMapping(method = RequestMethod.GET, value = ("/api/products/byid"), produces = "application/json")
	public Product getProduct(@RequestHeader(name = "id") Long id);
}
