package httpPostRequest.apigetway;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 *  添加资源
 * 
 * 
 * */
public class testPost_uc_addResource {

	public static void main(String[] args) throws Exception {		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//---0
		String url = "http://127.0.0.1:8762/api/u/u/test2" ;		//?aaa=123&ffd=我的&dfa=12312wwww
		 
		url = "http://127.0.0.1:8763/addResource" ;
		HttpPost httpPost = new HttpPost(url);	
		
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEyMzE3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1MDAwMTIyOTcyLCJleHAiOjE0OTU2MDQ5MjJ9.6MBtTb5w15lVnUs33CJAXPdE5sAMFfGW5GNOO2Tye7VdaPtuTatSp1o7E6o2NSmDFfQD1-cx5OaThyQbeh3hoA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTU0MzQzNjg4OSwiZXhwIjoxNTIxNTUwNjM2fQ.m9oMNC83aFDeYugjyyI1UR1d41mDSXOtPNgo1b-161lM81Osrab5cWApkndpG-BNZ7ktf9KmIYdUfOhgwVqmOg";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTY4MjgwNzAwNCwiZXhwIjoxNTIxNjkwMDA3fQ.13FCjG9HNIIFUWpFYWYhp9fVr4gaArZRnQ2YL70NOYBBjE4ptOFrNaVfEsBIbmsF09zJJnfLWqbPc-HIS19jKQ";
		
		httpPost.setHeader("Authorization", Token);  	
 
		 /**
		  * type; //1 接口   2 菜单   3按钮   4 图片    
		  * resource; //资源内容   链接   接口地址等 
		  * name;//资源名    	
		  * resourcedesc;// 资源描述    
		  * 
		  * */
		
		
		String type = "1";
		String resource = "/api/u/**";
		String name = "/api/u/";	 
		String resourcedesc ="UC网关";
		String  parameters = "{\"type\":\""+type+ "\","
							+ "\"resource\":\""+resource+"\","
							+ "\"name\":\""+name+"\","
							+ "\"resourcedesc\":\""+resourcedesc+"\" }";
		
		System.out.println(parameters);
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
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
