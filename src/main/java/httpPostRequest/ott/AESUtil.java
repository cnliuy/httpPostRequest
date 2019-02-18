package httpPostRequest.ott;



import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public enum AESUtil {
	;
	// 共通鍵
	//	private static final String ENCRYPTION_KEY = "1";
	private static final String ENCRYPTION_IV = "456789999asdfGHJ";

	public static String encrypt(String src,String password) {

		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, makeKey(password), makeIv());
			return Base64.encodeBytes(cipher.doFinal(src.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *
	 * @return 1 可用, 0 不可用
	 *
	 */
	public static AESResult decryptSrc(String src,String password) {

		int cando = 1;
		int dontdo = 0;
		String decryptedstr = "";

		AESResult ar = new AESResult();

		if (null == src || "".equals(src) || src.length() < 16) {

			ar.setCandoflag(dontdo);

		} else {

			try {
				decryptedstr = decrypt(src,password);
				ar.setCandoflag(cando);
				ar.setResult(decryptedstr);
			} catch (Exception e) {
				System.out.println("----密码解析失败");
				ar.setCandoflag(dontdo);
				ar.setResult("");
			}

		}

		return ar;

	}

	public static String decrypt(String src,String password) {
		String decrypted = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, makeKey(password), makeIv());
			decrypted = new String(cipher.doFinal(Base64.decode(src)));
		} catch (Exception e) {
			//throw new CustomException("解密出现异常:可能由于秘钥与版本号不匹配导致"+e.getMessage());
			
			System.out.println("解密出现异常:可能由于秘钥与版本号不匹配导致"+e.getMessage());
		}
		return decrypted;
	}

	static AlgorithmParameterSpec makeIv() {
		try {
			return new IvParameterSpec(ENCRYPTION_IV.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	static Key makeKey(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] key = md.digest(password.getBytes("UTF-8"));
			return new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
