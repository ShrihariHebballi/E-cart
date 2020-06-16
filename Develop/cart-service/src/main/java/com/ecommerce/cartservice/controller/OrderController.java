package com.ecommerce.cartservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.cartservice.controller.exception.ResourceNotFoundException;
import com.ecommerce.cartservice.dto.OrderProductDto;
import com.ecommerce.cartservice.interfaces.OrderProductService;
import com.ecommerce.cartservice.interfaces.OrderService;
import com.ecommerce.cartservice.interfaces.IProductService;
import com.ecommerce.cartservice.model.Order;
import com.ecommerce.cartservice.model.OrderProduct;
import com.ecommerce.cartservice.model.OrderStatus;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	IProductService iProductService;
	OrderService orderService;
	OrderProductService orderProductService;

	public OrderController(IProductService iProductService, OrderService orderService,
			OrderProductService orderProductService) {
		this.iProductService = iProductService;
		this.orderService = orderService;
		this.orderProductService = orderProductService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @NotNull Iterable<Order> list() {
		return this.orderService.getAllOrders();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Order> create(@RequestBody OrderForm form) {
		List<OrderProductDto> formDtos = form.getProductOrders();
		validateProductsExistence(formDtos);
		Order order = new Order();
		order.setStatus(OrderStatus.PAID.name());
		order = this.orderService.create(order);

		List<OrderProduct> orderProducts = new ArrayList<>();
		for (OrderProductDto dto : formDtos) {
			orderProducts.add(orderProductService.create(
					new OrderProduct(order, iProductService.getProduct(dto.getProduct().getId()), dto.getQuantity())));
		}

		order.setOrderProducts(orderProducts);

		this.orderService.update(order);

		String uri = ServletUriComponentsBuilder.fromCurrentServletMapping().path("/orders/{id}")
				.buildAndExpand(order.getId()).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
	}

	private void validateProductsExistence(List<OrderProductDto> orderProducts) {
		List<OrderProductDto> list = orderProducts.stream()
				.filter(op -> Objects.isNull(iProductService.getProduct(op.getProduct().getId())))
				.collect(Collectors.toList());

		if (!CollectionUtils.isEmpty(list)) {
			new ResourceNotFoundException("Product not found");
		}
	}

	public static class OrderForm {

		private List<OrderProductDto> productOrders;

		public List<OrderProductDto> getProductOrders() {
			return productOrders;
		}

		public void setProductOrders(List<OrderProductDto> productOrders) {
			this.productOrders = productOrders;
		}
	}
}
