package com.ecommerce.cartservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.cartservice.controller.exception.ResourceNotFoundException;
import com.ecommerce.cartservice.interfaces.IProductService;
import com.ecommerce.cartservice.model.Product;
import com.ecommerce.cartservice.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public String delete(long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id);
			String msg = "Successfully deleted Product ID : " + product.get().getId() + "\n Product Name : "
					+ product.get().getName();
			return msg;
		} else {
			return new String("Product does not exist, ERROR!!");
		}

	}
}
