package httpPostRequest.tools;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class encryptUtil {
	
	public static final String ENCODE_UTF8 = "UTF-8";
	public static final String ENCRYPT_TYPE_AES = "AES";
	public static final String ENCRYPT_TYPE_SHA_256 = "SHA-256";
	public static final String AES_PADDING_PKCS5 = "AES/ECB/PKCS5Padding";
	private static String ENCRYPT_TYPE_H_MAC_SHA_256 = "HmacSHA256";
	private static String ENCRYPT_TYPE_HMAC_SHA_256 = "HMACSHA256";
	private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
			'd', 'e', 'f'};
	
	public static String hmacSha256Encrypt(String data, String privateKey) throws Exception {
		Mac mac = Mac.getInstance(ENCRYPT_TYPE_H_MAC_SHA_256);
		byte[] secretByte = privateKey.getBytes("UTF-8");
		byte[] dataBytes = data.getBytes("UTF-8");
		SecretKeySpec secret = new SecretKeySpec(secretByte, ENCRYPT_TYPE_HMAC_SHA_256);
		mac.init(secret);
		byte[] doFinal = mac.doFinal(dataBytes);
		byte[] hexB = encode(doFinal);
		return new String(hexB);
	}
	
	public static byte[] encode(byte[] array) {
		return (new String(encodeHex(array))).getBytes();
	}
	
	public static char[] encodeHex(byte[] data) {
		int l = data.length;
		char[] out = new char[l << 1];
		int i = 0;

		for (int j = 0; i < l; ++i) {
			out[j++] = DIGITS[(240 & data[i]) >>> 4];
			out[j++] = DIGITS[15 & data[i]];
		}

		return out;
	}
	/**
	 * 加密调用方法
	 * */
	public static String messageSign(String message, String privateKey, String timestamp) throws Exception {
		String data = privateKey + message + timestamp;
		return hmacSha256Encrypt(data, privateKey) + timestamp;
	}


}
