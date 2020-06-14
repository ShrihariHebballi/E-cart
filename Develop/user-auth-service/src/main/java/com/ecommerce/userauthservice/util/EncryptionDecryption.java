package com.ecommerce.userauthservice.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class EncryptionDecryption {

	private static Cipher cipher;

	public SecretKey keyGenerator() throws NoSuchAlgorithmException, NoSuchPaddingException {
		byte[] encoded = { -120, 17, 42, 121, 32, 45, 98, 101, -11, 0, -70, 50, 44, -25, 15, 9};
		SecretKey secretKey = new SecretKeySpec(encoded, "AES");
		cipher = Cipher.getInstance("AES");
		return secretKey;
	}

	public String encrypt(String plainText, SecretKey secretKey) throws Exception {
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(hashing(plainText));
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	public byte[] decrypt(String encryptedText, SecretKey secretKey) throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		return decryptedByte;
	}

	public static byte[] hashing(String plainText) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(plainText.getBytes(StandardCharsets.UTF_8));
		return encodedhash;
	}

	public boolean compare(String password, byte[] decryptedHash) throws NoSuchAlgorithmException {
		return MessageDigest.isEqual(hashing(password), decryptedHash );

	}

}
