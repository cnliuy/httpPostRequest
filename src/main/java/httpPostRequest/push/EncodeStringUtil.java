package httpPostRequest.push;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

//import static org.mockito.Mockito.RETURNS_DEEP_STUBS;


import java.io.UnsupportedEncodingException;

public class EncodeStringUtil {
	
	/**
	 * 实现Base64编码
	 * 
	 * @param base64String 需要加密的报文
	 * @author ly
	 * 
	 * */
	public static String encodeStrByBase64(String base64String){
		 

		byte[] result = Base64.encodeBase64(base64String.getBytes());
		
		if (result == null) {
	        return null ;
	    }
	    String resultstr = new String(result);
	    return resultstr;
	}
	
	
	
	/**
	 * 实现SHA256加密
	 * @param str 需加密报文
	 * @return 加密后报文
	 * @author ly
	 */
	public static String encodeStrBySHA256(String str){
		MessageDigest messageDigest;
		String encodeStr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	/**
	 * 将byte转为16进制
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes){
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i=0;i<bytes.length;i++){
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length()==1){
				//1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
}
