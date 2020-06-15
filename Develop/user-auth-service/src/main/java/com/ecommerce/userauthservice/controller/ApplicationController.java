package com.ecommerce.userauthservice.controller;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.userauthservice.Dto.UserInput;
import com.ecommerce.userauthservice.IUserAuth.UserAuthInterface;

@RestController
@RequestMapping("/auth")
public class ApplicationController {

	@Autowired
	private UserAuthInterface userAuthI;

	@RequestMapping(value = ("/create"), method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> createUser(@RequestHeader(value = "password", required = true) String password,
			@RequestBody UserInput userInput) throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {
		return userAuthI.createUser(password, userInput);

	}

	@RequestMapping(value = ("/login"), method = RequestMethod.POST)
	public ResponseEntity<String> userLogin(@RequestHeader(value = "password", required = true) String password,
			@RequestHeader(value = "userName", required = true) String userName)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {
		return userAuthI.userLogin(password, userName);

	}

	@RequestMapping(value = ("/update"), method = RequestMethod.POST)
	public ResponseEntity<String> changePw(@RequestHeader(value = "oldPassword", required = true) String oldPassword,
			@RequestHeader(value = "newPassword", required = true) String newPassword,
			@RequestHeader(value = "userName", required = true) String userName)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {
		return userAuthI.changePw(oldPassword, newPassword, userName);

	}

}
