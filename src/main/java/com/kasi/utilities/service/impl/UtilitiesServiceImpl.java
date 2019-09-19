package com.kasi.utilities.service.impl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.stereotype.Service;

import com.kasi.utilities.service.UtilitiesService;

@Service
public class UtilitiesServiceImpl implements UtilitiesService {

	@Override
	public String base64Encode(String stringToEncode) {
		return Base64.getEncoder().encodeToString(stringToEncode.getBytes());
	}





	@Override
	public String base64Decode(String stringToDecode) {
		return new String(Base64.getDecoder().decode(stringToDecode.getBytes()));
	}





	@Override
	public String jasyptEncode(String stringToEncode, String key) {
		StrongTextEncryptor encryptor = new StrongTextEncryptor();
		encryptor.setPassword(key);
		return encryptor.encrypt(stringToEncode);
	}





	@Override
	public String jasyptDecode(String stringToDecode, String key) {
		StrongTextEncryptor encryptor = new StrongTextEncryptor();
		encryptor.setPassword(key);
		return encryptor.decrypt(stringToDecode);
	}





	@Override
	public String symmetricEncryption(String stringToEncrypt, String key, String algorithm)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException {
		String cipherText;
		SecretKeySpec secretKeyForEncrypt = new SecretKeySpec(key.getBytes(), algorithm);
		Cipher cipherForEncrypt = Cipher.getInstance(algorithm);
		cipherForEncrypt.init(Cipher.ENCRYPT_MODE, secretKeyForEncrypt);
		byte[] byteCipherText = cipherForEncrypt.doFinal(stringToEncrypt.getBytes());
		cipherText = Base64.getEncoder().encodeToString(byteCipherText);
		return cipherText;
	}





	@Override
	public String symmetricDecryption(String stringToDecrypt, String key, String algorithm)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException {
		String plainText;
		SecretKeySpec secretKeyForDecrypt = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipherForDecrypt = Cipher.getInstance("AES");
		cipherForDecrypt.init(Cipher.DECRYPT_MODE, secretKeyForDecrypt);
		byte[] byteDecryptedText = cipherForDecrypt.doFinal(Base64.getDecoder().decode(stringToDecrypt));
		plainText = new String(byteDecryptedText);
		return plainText;
	}

}
