package test.ph.gabijan.iiping.java.utils.crypto;

import static org.junit.Assert.*;
import ph.gabijan.iiping.java.utils.crypto.CryptoUtil;
import ph.gabijan.iiping.java.utils.crypto.ICryptoUtilAssymRSA;

public class Test {

	@org.junit.Test
	public void test() throws Throwable {

		ICryptoUtilAssymRSA cryptoUtil = new CryptoUtil();

		cryptoUtil
				.loadPrivateKey("D:/usr/src/local/code.github/java-utils/component/crypto/AssymX509Test/priv_key.der");
		cryptoUtil
				.loadPublicKey("D:/usr/src/local/code.github/java-utils/component/crypto/AssymX509Test/pub_key.der");

		String testString = "this is a test string";

		String encStr = cryptoUtil.priEncStr(testString);
		String decStr = cryptoUtil.pubDecStr(encStr);
		assertEquals("expected result on enc->dec for pri->pub", testString,
				decStr);

	}

}
