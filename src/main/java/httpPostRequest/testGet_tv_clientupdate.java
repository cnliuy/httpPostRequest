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
 * �ͻ�������
 *  
 *   ע�� 
 *   
 *   
 * */
public class testGet_tv_clientupdate {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://localhost:5080/wjsxclient?os=TV&versionNum=2.0.0.1" ;
		HttpGet httpget = new HttpGet(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNTI0IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNTAwNDU5MTIxMDgzLCJleHAiOjE1MDEwNjM5MjF9.h6XUW1f01gc1GkC-eznzd_tCzP2QdzGeoQmPCf4SnMvuQQgqRmbso0-1gQEOPoQgy-Nrtvftnq4mySVzZjj7Mg";
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
