package com.ecommerce.orderdetailsservice.model;

import java.time.LocalDate;

public class Product {

	private Long id;
	private String name;
	private Double price;
	private String pictureUrl;
	private String status;
	private LocalDate createdAt;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, Double price, String pictureUrl, String status, LocalDate createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.pictureUrl = pictureUrl;
		this.status = status;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

}
