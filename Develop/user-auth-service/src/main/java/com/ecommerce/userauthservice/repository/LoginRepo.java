package com.ecommerce.userauthservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.userauthservice.model.LoginCredentials;
import com.ecommerce.userauthservice.model.UserDetails;

public interface LoginRepo extends JpaRepository<LoginCredentials, String> {

	public LoginCredentials findByUserDetails(UserDetails userDetails);
}
