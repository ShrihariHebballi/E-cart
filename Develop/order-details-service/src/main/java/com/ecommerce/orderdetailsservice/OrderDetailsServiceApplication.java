package com.ecommerce.orderdetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDetailsServiceApplication.class, args);
	}

}
