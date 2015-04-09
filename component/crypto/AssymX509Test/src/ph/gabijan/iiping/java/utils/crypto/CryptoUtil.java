/*******************************************************************************
 * Copyright (c) 2015, iiPing
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
package ph.gabijan.iiping.java.utils.crypto;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import javax.xml.bind.DatatypeConverter;

public class CryptoUtil implements ICryptoUtilAssymRSA {

	byte[] priKeyBytes = null;
	byte[] pubKeyBytes = null;

	@Override
	public String pubDecStr(String encryptedBase64String)
			throws NoSuchAlgorithmException, IOException,
			InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		KeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_INSTANCE);

		RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.DECRYPT_MODE, pubKey);

		byte[] encryptedBytesStr = DatatypeConverter
				.parseBase64Binary(encryptedBase64String);

		return new String(cipher.doFinal(encryptedBytesStr));
	}

	@Override
	public String priEncStr(String rawString) throws NoSuchAlgorithmException,
			IOException, InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		KeySpec keySpec = new PKCS8EncodedKeySpec(priKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_INSTANCE);

		RSAPrivateKey privKey = (RSAPrivateKey) keyFactory
				.generatePrivate(keySpec);

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.ENCRYPT_MODE, privKey);

		byte[] encryptedString = cipher.doFinal(rawString.getBytes());
		
		

		return DatatypeConverter.printBase64Binary(encryptedString);
	}

	private static byte[] readFileToBytes(String filePath) throws IOException {

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		byte[] fileBytes = new byte[safeLongIntCast(file.length())];
		bis.read(fileBytes);

		bis.close();
		fis.close();

		return fileBytes;
	}

	private static int safeLongIntCast(long longValue) {
		if (longValue < Integer.MIN_VALUE || longValue > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(longValue
					+ " cannot be cast to int without changing its value.");
		}
		return (int) longValue;
	}

	@Override
	public void loadPrivateKey(String pathToDERFile) throws IOException {
		priKeyBytes = readFileToBytes(pathToDERFile);
	}

	@Override
	public void loadPublicKey(String pathToDERFile) throws IOException {
		pubKeyBytes = readFileToBytes(pathToDERFile);
	}

	@Override
	public String pubEncStr(String rawString) throws IOException,
			NoSuchAlgorithmException, IOException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		
		
		KeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_INSTANCE);

		RSAPublicKey pubKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.ENCRYPT_MODE, pubKey);
		
		
		byte[] encryptedString = cipher.doFinal(rawString.getBytes());
		return DatatypeConverter.printBase64Binary(encryptedString);		
		

	}

	@Override
	public String priDecStr(String encryptedBase64String) throws IOException,
			NoSuchAlgorithmException, IOException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException 
	{
		
		KeySpec keySpec = new PKCS8EncodedKeySpec(priKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_FACTORY_INSTANCE);

		RSAPrivateKey privKey = (RSAPrivateKey) keyFactory
				.generatePrivate(keySpec);

		Cipher cipher = Cipher.getInstance(CIPHER);
		cipher.init(Cipher.DECRYPT_MODE, privKey);

		byte[] encryptedBytesStr = DatatypeConverter
				.parseBase64Binary(encryptedBase64String);

		return new String(cipher.doFinal(encryptedBytesStr));
		
	}
}
