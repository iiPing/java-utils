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

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface ICryptoUtilAssymRSA {

	String KEY_FACTORY_INSTANCE = "RSA";
	String CIPHER = "RSA/ECB/PKCS1Padding";
	
	
	/**
	 * Loads your private Key
	 * @param pathToDERFile
	 * @throws IOException
	 */
	void loadPrivateKey(String pathToDERFile) throws IOException;
	
	/**
	 * Loads your public Key
	 * @param pathToDERFile
	 * @throws IOException
	 */
	void loadPublicKey(String pathToDERFile) throws IOException;
	

	/**
	 * Converts a raw string into an encrypted encoded BASE64 using public key
	 * @param rawString
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	String pubEncStr(String rawString)
			throws IOException, NoSuchAlgorithmException, IOException,
			InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
	
	/**
	 * Converts an encoded BASE64 encrypted raw string using private key
	 * 
	 * @param encryptedBase64String
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	String priDecStr(String encryptedBase64String)
			throws IOException, NoSuchAlgorithmException, IOException,
			InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException;	
	
	
	/**
	 * WARNING: not a typical usage scenario, you have been warned! <br/>
	 * Converts a raw string into an encrypted encoded BASE64 using a private key
	 * 
	 * @param rawString
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	String priEncStr(String rawString)
			throws NoSuchAlgorithmException, IOException,
			InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

	/**
	 * WARNING: not a typical usage scenario, you have been warned! <br/>
	 * Converts an encoded BASE64 encrypted into a raw string using public key
	 * 
	 * 
	 * 
	 * @param encryptedBase64String
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	String pubDecStr(String encryptedBase64String)
			throws IOException, NoSuchAlgorithmException, IOException,
			InvalidKeySpecException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
}
