package com.ecommerce.userauthservice.IUserAuth;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import com.ecommerce.userauthservice.Dto.UserInput;

public interface UserAuthInterface {

	public String createUser(String password, UserInput userInput) throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;
	
	public String userLogin(String password, String userName)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;
	
	public String changePw(String oldPassword, String newPassword, String userName) throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;
}
