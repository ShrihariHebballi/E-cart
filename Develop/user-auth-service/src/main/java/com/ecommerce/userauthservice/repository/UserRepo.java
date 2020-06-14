package com.ecommerce.userauthservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.userauthservice.model.UserDetails;

public interface UserRepo extends JpaRepository<UserDetails, String> {

	public Optional<UserDetails> findByUserName(String userName);
	
}
