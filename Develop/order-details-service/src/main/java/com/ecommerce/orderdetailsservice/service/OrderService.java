package com.ecommerce.orderdetailsservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.orderdetailsservice.IOrder.OrderInterface;
import com.ecommerce.orderdetailsservice.client.CartService;
import com.ecommerce.orderdetailsservice.dto.OrderProductDto;
import com.ecommerce.orderdetailsservice.model.Order;
import com.ecommerce.orderdetailsservice.model.OrderForm;
import com.ecommerce.orderdetailsservice.model.OrderProduct;
import com.ecommerce.orderdetailsservice.model.OrderProductKey;
import com.ecommerce.orderdetailsservice.model.OrderStatus;
import com.ecommerce.orderdetailsservice.model.Product;

@Service
public class OrderService implements OrderInterface {

	@Autowired
	private OrderUtils orderUtils;

	@Autowired
	private CartService cartService;

	@Override
	public Iterable<Order> getAllOrders() {
		return orderUtils.getAllOrders();
	}

	@Override
	public ResponseEntity<Order> createOrder(OrderForm form) {
		List<OrderProductDto> formDtos = form.getProductOrders();

		Order order = new Order();
		order.setStatus(OrderStatus.PENDING.name());
		order.setUserId(form.getUserId());
		order = orderUtils.persistOrder(order);

		List<OrderProduct> orderProduct = new ArrayList<>();
		for (OrderProductDto dto : formDtos) {
			orderProduct
					.add(new OrderProduct(new OrderProductKey(order.getId(), dto.getProductId()), dto.getQuantity()));
		}
		order.setTotalNumberOfProducts((long) orderProduct.size());
		order.setOrderAmount(orderTotal(formDtos));
		order = orderUtils.persistOrder(order);
		orderProduct = orderUtils.persistOrderProduct(orderProduct);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}

	public Double orderTotal(List<OrderProductDto> formDtos) {
		double sum = 0D;
		List<Product> productDetails = new ArrayList<>();
		for (OrderProductDto op : formDtos) {
			Product product = cartService.getProduct(op.getProductId());
			productDetails.add(product);
			sum = +product.getPrice();
		}
		return sum;
	}

}
