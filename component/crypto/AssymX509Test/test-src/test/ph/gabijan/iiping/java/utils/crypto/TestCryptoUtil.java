package test.ph.gabijan.iiping.java.utils.crypto;

import static org.junit.Assert.*;
import ph.gabijan.iiping.java.utils.crypto.CryptoUtil;
import ph.gabijan.iiping.java.utils.crypto.ICryptoUtilAssymRSA;

public class TestCryptoUtil {

	/**
	 * WARNING: This unit test is very uncommon, however there are cases
	 * when you handshake in reverse to find out the validity 
	 * (usually in self-signed scenarios).
	 * 
	 * NOTE: IBM J9 will fail, see http://www-01.ibm.com/support/docview.wss?uid=swg1IV18625
	 * a workaround is adding the JVM arg -Dcom.ibm.crypto.provider.DoRSATypeChecking=false
	 * @throws Throwable
	 */
	@org.junit.Test
	public void testPrivateEncryptPublicDecrypt() throws Throwable {

		ICryptoUtilAssymRSA cryptoUtil = new CryptoUtil();

		cryptoUtil
				.loadPrivateKey("priv_key.der");
		cryptoUtil
				.loadPublicKey("pub_key.der");

		String testString = "this is a test string";

		String encStr = cryptoUtil.priEncStr(testString);
		String decStr = cryptoUtil.pubDecStr(encStr);
		assertEquals("expected result on enc->dec for pri->pub", testString,
				decStr);

	}

	/**
	 * The typical common asymmetric scenario
	 * @throws Throwable
	 */
	@org.junit.Test
	public void testPublicEncryptPrivateDecrypt() throws Throwable {

		ICryptoUtilAssymRSA cryptoUtil = new CryptoUtil();

		cryptoUtil
				.loadPrivateKey("priv_key.der");
		cryptoUtil
				.loadPublicKey("pub_key.der");

		String testString = "this is a test string";

		String encStr = cryptoUtil.pubEncStr(testString);
		String decStr = cryptoUtil.priDecStr(encStr);
		assertEquals("expected result on enc->dec for pub->pri", testString,
				decStr);

	}	
}
