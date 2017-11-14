package httpPostRequest;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class HMACSHA256Sign {

	public static void main(String[] args) throws Exception {
		String privateKey = "The HMAC private key";
		String data ="{\"appId\":\"98726189\"}";
		
		String singstring = HMACSHA256Sign.sign(privateKey,data);
		System.out.println("<"+singstring+">");
	}
	
	
	/**
	 * 生成签名
	 * 
	 * */
	public static String sign(String  privateKey , String data) throws Exception {
		
		//私有密钥
		//String privateKey = "The HMAC private key";
		//签名内容
		//String data ="{\"appId\":\"98726189\"}";
		Date date = new  Date();
		SimpleDateFormat riqi= new SimpleDateFormat("YYYYMMddHHmmss");
		String timestamp=riqi.format(date);
		//String timestamp = "20141112101223";
		//System.out.println("timestamp:"+timestamp);
		data = privateKey + data + timestamp;
		Mac mac = Mac.getInstance("HmacSHA256");
		byte[] secretByte = privateKey.getBytes("UTF-8");
		byte[] dataBytes = data.getBytes("UTF-8");
		//生成签名
		SecretKey secret = new SecretKeySpec(secretByte, "HMACSHA256");
		mac.init(secret);
		byte[] doFinal = mac.doFinal(dataBytes);
		byte[] hexB = new Hex().encode(doFinal);
		String checksum = new String(hexB);
		//签名后面拼上时间戳
		checksum = checksum + timestamp;
		//返回最终签名
		return checksum;
		
	}
	
	
	

}
