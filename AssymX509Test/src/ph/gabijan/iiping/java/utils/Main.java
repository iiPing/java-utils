// Copyright (c) 2015, iiPing
// All rights reserved.
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
// * Redistributions of source code must retain the above copyright notice, this
// list of conditions and the following disclaimer.
// * Redistributions in binary form must reproduce the above copyright notice,
// this list of conditions and the following disclaimer in the documentation
// and/or other materials provided with the distribution.
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

package ph.gabijan.iiping.java.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import java.util.Base64;

import javax.crypto.Cipher;

public class Main {

	public static void main(String... strings) throws Exception {
//		System.out.println(encrypt("this is a string"));
//		System.out
//				.println(decrypt("Gd8aY3Wc3W49/roeXnNXKTalCyTeW1bBQH0DKyjT55z1EzS+2a8G9RV4QbqccJ6ECInQIDYRyZYMFg2q/XuZPhf6ia3aGiCiqlDda3kNRJ1uwnNEDAfVUJV2dR/bzpWRzFuPPKA33P5yQITbvqHdg14MgHdgjB8+vaVWLK1jBxZLblq0sWp9D/y5M1/3ac3KEBkrIDEfxKj0tEKiosLZ2XqmzyihUoqvk7NTRKeC/ObGALLIW634zRKRC+Il2Sivs9kDRsBQxajBGKeovMmgYqn2+XuVgPSgb5YyOX9xFh+fI/JDzntsmkK2O6tjONBWf9F33DfYIJxzFv7KHWjPIIvU/3H14laOqekTmwtdss0XftvZeFZrI7105UCgdQ0b8qOSYZMOatIwQ6bunGhz0Am47tweKy9FFUtLAFCHXrZKHeV7jN+4yIWv/h3Xmbqu+/xKzbJ2lK+UTjxCy/5J8JAKKK99OToNISBXOHSmZMEJWN5ErrVrT3mU2kcCM02A1UQBmBinm2835fp/JL2LUNAMRzQ9JJIqhlPcpnQ9JKHzjtVZT5DVvELtlJLiBgUVwYUZZO/nPuWfdCcTvLutMhPnET1GVrYjDzYI7KW/dA2O0oN5Xtpg7W4BO90aAIvMaCQXli4PUfw/WT4gKFGdKxT15BadUjKBlDKRy1RKo1c="));
//		
		
		ICryptoUtilAssymRSA cryptoUtil = new CryptoUtil();
		
		cryptoUtil.loadPrivateKey("D:/usr/local/src/alpha/luna/AssymX509Test/priv_key.der");
		cryptoUtil.loadPublicKey("D:/usr/local/src/alpha/luna/AssymX509Test/pub_key.der");
		
		
//		System.out.println(cryptoUtil.priEncStr("D:/usr/local/src/alpha/luna/AssymX509Test/priv_key.der", "this is a test string"));
//		System.out
//				.println(cryptoUtil.pubDecStr("D:/usr/local/src/alpha/luna/AssymX509Test/pub_key.der","mdRyPTs/ZO07n9TvmI6yEcSJtY+Few8pCpaLYpR0eTr9cJLK/f9ENT/MN3TQmJ6Pnbpdh3oB84x9lC1uToNcbhjcnAJPhsbb2TR3nCaXcvhzZn3jymW3+5UHe/3P+IdTZRA1zMW3rep/29mhzs33wRmkVUw8VTVMHJzcZxfJAUwHz8Y84lfSlY4ol+irK1ANzePqL4rRWkyzDqNxRoZ48yvB/5CA93MjhOxmRXV/7wOs8dcCNci40Gwx05o4a6OZeWlOv1SNLTyAjglmzP9/GfFS1gi7wpMRQt7kCEDeYgiP9YZrfBy6TtnynPKcK+MTgcAcGBytksG8OIKQIGxvJPYIhOQGWXERDaSPWI54HYr0wabYOXqI2c6sovF7PHkH2KC5A7VTJjLwYjy2ADLQOTXamX8lqUv9NhZA2OkxmfA7+kedZ1eLZWLdF12FAO5HgDQwpiQnYucB3tEoK4L2NRXY2lvgfU5SN1KmfoU3ACMrCuINy0nl/uGnCCyaNA6o/xjay60AGj7ijZFrCz4/VQnFuquM8vE3J61696xp2o992fHDjDfyjTINvZVKqmTb3SLgdPr4doX4JUxaAu500OtUrJYRcYbO6PGcIBAMjr6PrJIAUgQPCJl8WHXt35bLa294BhasK4TrBzOSjgqsXnZsA6ShQlYoyyJriTOqjNA="));
				
	
	}

//	private static String decrypt(String str) throws Exception {
//		BufferedInputStream bis = null;
//
//		File privKeyFile = new File(
//				"D:/usr/local/src/alpha/luna/AssymX509Test/key.der");
//
//		bis = new BufferedInputStream(new FileInputStream(privKeyFile));
//
//		byte[] privKeyBytes = new byte[(int) privKeyFile.length()];
//		bis.read(privKeyBytes);
//		bis.close();
//		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//		KeySpec ks = new PKCS8EncodedKeySpec(privKeyBytes);
//
//		RSAPrivateKey privKey = (RSAPrivateKey) keyFactory.generatePrivate(ks);
//
//		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//		cipher.init(Cipher.DECRYPT_MODE, privKey);
//
//		byte[] base64Dec = Base64.getDecoder().decode(str.getBytes());
//
//		String retVal = new String(cipher.doFinal(base64Dec));
//
//		return retVal;
//
//	}
//
//	private static String encrypt(String str) throws Exception {
//
//		FileInputStream fis = new FileInputStream(
//				new File(
//						"D:/usr/local/src/alpha/luna/AssymX509Test/iiping_ss_local-pub.crt"));
//
//		CertificateFactory certificateFactory = CertificateFactory
//				.getInstance("X.509");
//
//		X509Certificate certificate = (X509Certificate) certificateFactory
//				.generateCertificate((InputStream) fis);
//		PublicKey pk = certificate.getPublicKey();
//
//		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//		cipher.init(Cipher.ENCRYPT_MODE, pk);
//
//		return Base64.getEncoder().encodeToString(
//				cipher.doFinal(str.getBytes()));
//	}

}
