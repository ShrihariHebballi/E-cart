package com.ecommerce.orderdetailsservice.model;

import java.util.List;

import com.ecommerce.orderdetailsservice.dto.OrderProductDto;

public class OrderForm {
	private List<OrderProductDto> productOrders;
	private Long userId;

	public OrderForm() {
		super();
	}

	public List<OrderProductDto> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<OrderProductDto> productOrders) {
		this.productOrders = productOrders;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
