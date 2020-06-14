package com.ecommerce.userauthservice.util;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.userauthservice.model.LoginCredentials;
import com.ecommerce.userauthservice.model.UserDetails;
import com.ecommerce.userauthservice.repository.LoginRepo;
import com.ecommerce.userauthservice.repository.UserRepo;

@Transactional
@Component
public class UserUtils {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private LoginRepo loginRepo;

	public UserDetails presistUser(UserDetails userDetails) {
		return userRepo.save(userDetails);
	}

	public LoginCredentials presistCredentials(LoginCredentials credentials) {
		return loginRepo.save(credentials);
	}

	public Optional<UserDetails>  findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

	
	public LoginCredentials findByUserId(UserDetails userDetails) {
		return loginRepo.findByUserDetails(userDetails);
	}
	
}
