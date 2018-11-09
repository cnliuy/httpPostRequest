package httpPostRequest.tvbss;

import java.nio.charset.Charset;
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


public class Post_uploadUserInfoToJoinPromotion_Muti {
	
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 0 ; i< 1000000 ; i++) {
			
			Post_uploadUserInfoToJoinPromotion_Muti p = new Post_uploadUserInfoToJoinPromotion_Muti();
			p.uploadUserInfoToJoinPromotion();
			System.out.println("执行第"+i+"次");
			System.out.println("-----------");
		}
		
		
	}
	
	/**
	 * 用户参加某个地区的某个活动
	 * 
	 * 
	 * */
	public  void uploadUserInfoToJoinPromotion( ) throws Exception {
		System.out.println(new Date());
		String  url = "http://localhost:6280/uploadUserInfoToJoinPromotion";
		
		url = "http://60.29.181.148:6280/uploadUserInfoToJoinPromotion";

		String parameters = "{\"useri\":\"adminadminadminadminadmin\"}";
		parameters = "{\"useri\":\"3SJbNr38GewUpnmrkon92g==\"}";
		
		parameters = "{\"promotionid\":\"022-20181022142312-jdcx\",\"numstr\":\"15522214511\","
				+ "\"areacode\":\"022\",\"numberType\":\"1\","
				+ "\"ownernumber\":\"15522214511\",\"ownerarea\":\"022\","    // ownerarea 以此地区号为准
				+ "\"fee\":\"100\",\"phonenum\":\"15522214512\"}";
		
		parameters = "{\"promotionid\":\"022-20181022142312-jdcx1\","
				+ "\"numberType\":\"1\","
				+ "\"ownernumber\":\"022-22214515\",\"ownerarea\":\"022\","    // ownerarea 以此地区号为准
				+ "\"fee\":\"100\",\"phonenum\":\"15522214512\"}";
		
		parameters = "{\"promotionid\":\"022-20181022142312-jdcx1\","
				+ "\"numberType\":\"1\","
				+ "\"ownernumber\":\"022-22214516\",\"ownerarea\":\"022\","    // ownerarea 以此地区号为准
				+ "\"fee\":\"100\",\"phonenum\":\"15522214511\"}";
		
		
		parameters = "{\"promotionid\":\"022-20181022142312-jdcx1\","
				+ "\"numberType\":\"1\","
				+ "\"ownernumber\":\"022-22214517\",\"ownerarea\":\"022\","    // ownerarea 以此地区号为准
				+ "\"fee\":\"100\",\"phonenum\":\"15522214510\"}";
		
		parameters = "{\"promotionid\":\"022-20181022142312-jdcx1\","
				+ "\"numberType\":\"1\","
				+ "\"ownernumber\":\"15522214510\",\"ownerarea\":\"022\","    // ownerarea 以此地区号为准
				+ "\"fee\":\"100\",\"phonenum\":\"022-22214517\"}";
	 	String encrypted = AESUtil.encrypt(parameters);
		System.out.println(parameters);
	 	System.out.println(encrypted);
	 	
	 	
		parameters = "{\"useri\":\""+encrypted+"\"}";
		System.out.println(parameters);
		/**
		 * 活动id promotionid
		 * 
		 * 充值号码,充值地区,号码类别, numstr,areacode,numberType,
		 * 
		 * 属主号码,属主地区,属主类型 ownernumber,ownerarea,ownertype,
		 * 
		 * 时间精确到秒(20181022142312), 金额(分), 手机号（密文传输，加密方式自定） date,fee,phonenum
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
		System.out.println(new Date());

		/**
		 * 
		 * 
		 * */
	}
	

}
