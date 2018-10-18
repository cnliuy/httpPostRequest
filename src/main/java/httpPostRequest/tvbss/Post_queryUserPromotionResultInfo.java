package httpPostRequest.tvbss;

import java.nio.charset.Charset;
import java.util.ArrayList;
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


public class Post_queryUserPromotionResultInfo {
	
	/**
	 * 查询 用户参加某个地区的某个活动的
	 * 结果信息
	 * 
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		
		String  url = "http://localhost:6280/queryUserPromotionResultInfo";
		String parameters = "{\"useri\":\"adminadminadminadminadmin\"}";
		parameters = "{\"upromotionresultinfo\":\"3SJbNr38GewUpnmrkon92g==\"}";
		/**
		 * promotionid
		 * ownernumber
		 * ownerarea
		 * phonenum
		 * */		
		parameters = "{\"promotionid\":\"022-20181022142312-jdcx\","
				+ "\"ownernumber\":\"022-22214511\",\"ownerarea\":\"022\","    // ownerarea 以此地区号为准
				+ "\"phonenum\":\"15522214512\"}";
	 	String encrypted = AESUtil.encrypt(parameters);
		
		parameters = "{\"upromotionresultinfo\":\""+encrypted+"\"}";
		
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
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		//httpPost.setEntity(new HttpEntity);setRequestEntity(new StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
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
		    System.out.println(response2txt);

		} finally {
		    response2.close();
		} 
	}
	

}
