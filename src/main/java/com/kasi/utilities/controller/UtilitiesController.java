
package com.kasi.utilities.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kasi.utilities.constants.EncryptionAlgorithms;
import com.kasi.utilities.service.UtilitiesService;

@RestController("/utilities")
public class UtilitiesController {

	@Autowired
	UtilitiesService utilitiesService;





	@GetMapping("/base-64/encode")
	public String getBase64EncodedString(@RequestParam(required = true) String stringToEncode) {
		return utilitiesService.base64Encode(stringToEncode);
	}





	@GetMapping("/base-64/decode")
	public String getBase64DecodedString(@RequestParam(required = true) String stringToDecode) {
		return utilitiesService.base64Decode(stringToDecode);
	}





	@GetMapping("/jasypt/encode")
	public String getJasyptEncodedString(@RequestParam(required = true) String stringToEncode,
			@RequestParam(required = true) String key) {
		return utilitiesService.jasyptEncode(stringToEncode, key);
	}





	@GetMapping("/jasypt/decode")
	public String getJasyptDecodedString(@RequestParam(required = true) String stringToDecode,
			@RequestParam(required = true) String key) {
		return utilitiesService.jasyptDecode(stringToDecode, key);
	}





	@GetMapping("/symmetric/encrypt")
	public String getSymmetricEncryptedString(@RequestParam(required = true) String stringToEncrypt,
			@RequestParam(required = true) String key, @RequestParam(required = true) EncryptionAlgorithms algorithm)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		return utilitiesService.symmetricEncryption(stringToEncrypt, key, algorithm.name());
	}





	@GetMapping("/symmetric/decrypt")
	public String getSymmetricDecryptedString(@RequestParam(required = true) String stringToDecrypt,
			@RequestParam(required = true) String key, @RequestParam(required = true) EncryptionAlgorithms algorithm)
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException {
		return utilitiesService.symmetricDecryption(stringToDecrypt, key, algorithm.name());
	}

}
