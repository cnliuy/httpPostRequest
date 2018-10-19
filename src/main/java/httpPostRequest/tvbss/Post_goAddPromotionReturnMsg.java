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

/**
 * 新建活动的返回信息  自定义
 * 
 * 上传信息不做加密
 * 
 * */
public class Post_goAddPromotionReturnMsg {
	

	public static void main(String[] args) throws Exception {
		
		String  url = "http://localhost:6280/goAddPromotionReturnMsg";
		String parameters = "{\"promotioni\":\"adminadminadminadminadmin\"}";		 
		
		/**
		 * resultsrc 的 现在入参
		 * 	 
		 * 4A6000  恭喜,成功参加了活动
		 * 4A6002  您已参加过该活动
		 * 4A6004  用户信息上传失败，不能参加活动
		 * 4A6005  活动已经失效
		 * 4A6007 参数错误
		 * 
		 *  	promotionid; 必传
				areacode; 必传
				resultsrc; 必传   对应活动的返回值  
				private String msg1;
				private String msg2;
				private String msg3;
				private String msg4;
				private String msg5;
				private String msg6;
				private String msg7; 
		 * 
		 * 
		 * 4A6030 
		 * */		
		
		parameters = "{\"promotionid\":\"022-20181022142312-jdcx\",\"areacode\":\"022\","
				+ "\"resultsrc\":\"4A6030\",\"msg1\":\"恭喜中奖\",\"msg2\":\"恭喜中奖 信息2\",\"msg3\":\"恭喜中奖 信息3\"}"  ;
	 	 
		 
	 
		
		
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
