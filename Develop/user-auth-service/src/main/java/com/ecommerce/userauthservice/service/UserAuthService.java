package com.ecommerce.userauthservice.service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.userauthservice.Dto.UserInput;
import com.ecommerce.userauthservice.IUserAuth.UserAuthInterface;
import com.ecommerce.userauthservice.model.LoginCredentials;
import com.ecommerce.userauthservice.model.UserDetails;
import com.ecommerce.userauthservice.util.EncryptionDecryption;
import com.ecommerce.userauthservice.util.UserUtils;

@Service
public class UserAuthService implements UserAuthInterface {

	@Autowired
	private UserUtils userUtils;

	@Autowired
	private EncryptionDecryption encryptDecrypt;

	@Override
	public String createUser(String password, UserInput userInput)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {

		try {
			UserDetails userDetails = new UserDetails(userInput.getUserName(), userInput.getEmail());
			userDetails = this.userUtils.presistUser(userDetails);

			LoginCredentials credentials = new LoginCredentials();
			credentials.setUserDetails(userDetails);
			credentials.setPassword(encryptDecrypt.encrypt(password, encryptDecrypt.keyGenerator()));
			credentials = this.userUtils.presistCredentials(credentials);
		} catch (Exception e) {
			return new String("Error!!");
		}
		return null;
	}

	@Override
	public String userLogin(String password, String userName)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {
		Optional<UserDetails> userDetails = userUtils.findByUserName(userName);
		if (userDetails.isPresent()) {
			LoginCredentials loginCred = userUtils.findByUserId(userDetails.get());
			boolean value = encryptDecrypt.compare(password,
					encryptDecrypt.decrypt(loginCred.getPassword(), encryptDecrypt.keyGenerator()));
			System.out.println(value);
		}

		return null;
	}

	@Override
	public String changePw(String oldPassword, String newPassword, String userName)
			throws NoSuchAlgorithmException, NoSuchPaddingException, Exception {
		boolean value = false;
		LoginCredentials loginCred = new LoginCredentials();
		Optional<UserDetails> userDetails = userUtils.findByUserName(userName);
		if (userDetails.isPresent()) {
			loginCred = userUtils.findByUserId(userDetails.get());
			value = encryptDecrypt.compare(oldPassword,
					encryptDecrypt.decrypt(loginCred.getPassword(), encryptDecrypt.keyGenerator()));
			System.out.println(value);
		}
		if (value) {
			loginCred.setPassword(encryptDecrypt.encrypt(newPassword, encryptDecrypt.keyGenerator()));
			loginCred = this.userUtils.presistCredentials(loginCred);
		}
		return null;
	}

}
