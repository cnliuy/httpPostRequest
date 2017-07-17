package httpPostRequest;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 全版本的  更新关键字段 
 * 测试 更新用户 2
 * 
 *   tochangeuname
 *   oldpasswd  passwd 
 *   phonenum
 *   
 *   注意 
 *   
 *   
 * */
public class testPost_tv_modifiUser_part2 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//---0
		String url = "http://localhost:5080/modifylTvUserUsername" ;
		//---1
		url="http://localhost:5080/modifylTvUserPasswd";
		//---2
		//url="http://localhost:8080/modifylTvUserPhonenum";
		HttpPost httpPost = new HttpPost(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEyMzE3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1NDUyMjA5ODgzLCJleHAiOjE0OTYwNTcwMDl9.ek4YYsI89AyNBf8SE9vgezLTg_p7bzHpU5oL6ORafwUDKmlSECbLTMsajb-qU65N4qhmR9o6Bh25LLqApbFvwA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNTI2MTIiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE0OTU3NjU3MjQ1NjAsImV4cCI6MTQ5NjM3MDUyNH0.0DjWyayeG2Z23NOrXIFnELu4r4oS77kRE5L9PGvfk4uycZTHy_fU995aKuTjeatWYJCC-OQS-RBcWFAIgIhK0w";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNTI2MTYiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE0OTU3NjgyMzE0MjgsImV4cCI6MTQ5NjM3MzAzMX0.5JSzcey-XqvQjH2AwZfdd00KGFN28hdX3vGTVtuKwEl83VdstuszojrmltWwD0kGP64HIVkPU5YQ5NRf2zAxGw";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNTI0IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNTAwMjU0NTIyNjc0LCJleHAiOjE1MDA4NTkzMjJ9.1Aj1GsM1V7F1NhUEaDcyy7kfljKeJ_mez5QYRmimHyDOrBTmhjPI-xPmwLCHlCEVw5fqkH65NG32hnqDshnuuA";
		httpPost.setHeader("Authorization", Token);  	
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		

		//-----0
		//nvps.add(new BasicNameValuePair("tochangeuname", "username12317")); 
		//httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.addHeader("Content-Type","application/x-www-form-urlencoded");
		
		httpPost.setHeader("Accept", "application/json");  
		//-----1
		nvps.add(new BasicNameValuePair("oldpasswd", "123456")); 
		nvps.add(new BasicNameValuePair("passwd", "12345")); 
		
		//-----2
		//nvps.add(new BasicNameValuePair("phonenum", "112233445611")); 
		
		
		//nvps.add(new BasicNameValuePair("phonenum", ""));
 		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps ,"UTF-8"));
		//httpPut.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		//CloseableHttpResponse response2 = httpclient.execute(httpPut);
		try {
			
		    System.out.println(response2.getStatusLine());		    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2txt);

		} finally {
		    response2.close();
		}

	}

}
