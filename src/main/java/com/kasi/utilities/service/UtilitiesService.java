package com.kasi.utilities.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface UtilitiesService {

	String base64Encode(String stringToEncode);





	String base64Decode(String stringToDecode);





	String jasyptEncode(String stringToEncode, String key);





	String jasyptDecode(String stringToDecode, String key);





	String symmetricEncryption(String stringToEncrypt, String key, String algorithm) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;





	String symmetricDecryption(String stringToDecrypt, String key, String algorithm) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

}
