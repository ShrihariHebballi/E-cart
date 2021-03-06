package com.ecommerce.userauthservice.IUserAuth;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import org.springframework.http.ResponseEntity;

import com.ecommerce.userauthservice.Dto.Response;
import com.ecommerce.userauthservice.Dto.UserInput;

public interface UserAuthInterface {

	public ResponseEntity<Response> createUser(String password, UserInput userInput)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;

	public ResponseEntity<Response> userLogin(String password, String userName)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;

	public ResponseEntity<Response> changePw(String oldPassword, String newPassword, String userName)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;
}
