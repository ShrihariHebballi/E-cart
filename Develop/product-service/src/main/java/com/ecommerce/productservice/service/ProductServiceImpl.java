package com.ecommerce.productservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.productservice.controller.exception.ResourceNotFoundException;
import com.ecommerce.productservice.interfaces.ProductInterface;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductInterface {

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
	public ResponseEntity<Product> save(Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<String> delete(long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id);
			String msg = "Successfully deleted Product ID : " + product.get().getId() + "\n Product Name : "
					+ product.get().getName();
			return new ResponseEntity<>(msg, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new String("Product does not exist, ERROR!!"), HttpStatus.NO_CONTENT);
		}

	}
}
