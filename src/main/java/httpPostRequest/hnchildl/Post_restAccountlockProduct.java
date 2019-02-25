package httpPostRequest.hnchildl;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class Post_restAccountlockProduct  {
	
	/**
	 * 河南 童锁
	 * 结果信息
	 * 
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		System.out.println(new Date());
		String  baseurl =  "http://182.118.2.1:38297";
		String  apiurl = "/api/rest/accountlock/product";
		String  url = baseurl + apiurl ;
		
		String  accesstoken = "at201810251705052322C819986130D0";
	 
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		
		//96596 
		//固定前缀标识 5位 + 时间戳 (yyyyMMddHHmmss 14位 )+ 序号（ 18位自增）
		SHA256HN.seq++;
		
		String productID = "hxlmby020@204";
		String seq_str = String.format("%018d", SHA256HN.seq); 
		String  transactionID = "96596"+date+ seq_str;
		String  loginaccount = "371654564701732403";
		
		/**
		 * accesstoken: xsercd532ssdfswer33siisop1mkjs13 
		 * transactionID: 9000000120180214132930000000000000000001 
		 * loginAccount: test001”, 
		 * MD5( access token+transactionID+loginAccount): 3f8b58f44b4b76bbbec4b27ace8672f5 
		 * 
		 * */
		String  wantsignstr =  accesstoken+ transactionID+ loginaccount +productID ;
		//String  sign =  SHA256HN.encrypt(wantsignstr);
		System.out.println("加密的串:"+ wantsignstr );
		String  sign =  MD5_1.md5(wantsignstr); 
		
		/**
		 * POST /api/rest/accountlock/product 
			{ 
			  "version" : "1.0", 
			  "accesstoken": "xsercd532ssdfswer33siisop1mkjs13", 
			  "transactionID": "9000000120180214132930000000000000000001", 
			  "loginaccount": "test001", 
			  "productID": "prod000212003310001", 
			  "sign": "0b2fb51a91403f2402054eb0e8dd31e8" 
			} 

{"version" : 1.0","accesstoken": "xsercd532ssdfswer33siisop1mkjs13","transactionID": "9000000120180214132930000000000000000001",
"loginaccount": "test001", 
  "productID": "prod000212003310001", "sign": "0b2fb51a91403f2402054eb0e8dd31e8"} 
  
  
  
 
  
		 * 
		 * */
		
		String parameters1 = "";
		parameters1 = "{\"version\":\"1.0\",\"accesstoken\":\""+accesstoken+"\",\"transactionID\":\""+transactionID+"\"";
		parameters1	= parameters1 + ",\"loginAccount\": \""+loginaccount+"\",\"productID\": \""+productID+"\",\"sign\":\""+sign+"\" } ";
		
 
	 
		System.out.println(parameters1);
	 	
		 
		
		/**
		 * 活动id promotionid
		 * 
		 * 属主号码,属主地区  ownernumber,ownerarea 
		 * 
		 * 手机号(密文传输，加密方式自定) ,phonenum
		 * 
		 * */		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();	
		HttpPost httpPost = new HttpPost();		
		httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		//String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJpZFwiOjMsXCJwaG9uZW51bVwiOlwiMTIzNDU2Nzg5MTFcIixcInVzZXJjYXJkaWRcIjpcIjM2Mjg2NjE5OTkwOTIzXCIsXCJ1c2VybmFtZVwiOlwiMzYyODY2MTk5OTA5MjNfMTIzNDU2Nzg5MTFcIixcInVzZXJvdGlkXCI6MyxcInVzZXJ0eXBlXCI6XCIxXCJ9IiwiZXhwIjoxNTM4MjE1MzU3fQ.W1cJFgpXLgRcjIAwgLbzQUYeJhI7Dhi1jMOn75R-BTKOSKsRNMuMKKRoQEscugfuurznVROZJPJK9R1HtlYhkQ";
		//httpPost.setHeader("Authorization", "token-"+ Token);  
		//parameters = "{\"username\":\"admin1\",\"password\":\"$2a$10$3DYbbsL94OFlV6McoKS8V./E7oT5p9bTeMymmWPeUB3wo7wX0kssC\"}";
		
		httpPost.setEntity(new StringEntity(parameters1, Charset.forName("UTF-8")));		
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();  
		    
		    Header headers[] = response2.getAllHeaders();
			int ii = 0;
			while (ii < headers.length) {
				System.out.println(headers[ii].getName() + ":"
						+ headers[ii].getValue());
				++ii;
			}
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println("=="+response2txt);

		} finally {
		    response2.close();
		} 
		
		System.out.println(new Date());
	}
	

}
