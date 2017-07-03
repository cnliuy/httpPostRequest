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
 * 
 * 测试 生活圈 获取
 * 
 *   
 *   注意 
 *   
 *   
 * */
public class testGet_tv_livingcircle {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://60.29.181.148:5080/livingcircle?lctype=1" ;
		url = "http://127.0.0.1:5080/livingcircle?lctype=1" ;
		HttpGet httpget = new HttpGet(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIrODYzMTYyNDI5MDA3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk4NzMwMjc4MjYwLCJleHAiOjE0OTkzMzUwNzh9.s1lInvfwAz4U098wmq49jao0ic7zk01y5TPRRHhbv24U2wXLB_BcDKGrLLHkblNulkpfci2jR-yKwTFda4FuVA";
		httpget.setHeader("Authorization", Token);  	
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		


		CloseableHttpResponse response2 = httpclient.execute(httpget);
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
