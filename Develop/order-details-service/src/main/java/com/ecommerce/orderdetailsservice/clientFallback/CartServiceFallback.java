package com.ecommerce.orderdetailsservice.clientFallback;

import com.ecommerce.orderdetailsservice.client.CartService;
import com.ecommerce.orderdetailsservice.model.Product;

public class CartServiceFallback implements CartService{

	@Override
	public Product getProduct(Long id) {
		return null;
	}

}
