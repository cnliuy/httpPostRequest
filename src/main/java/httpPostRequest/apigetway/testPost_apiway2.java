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
 *  
 * 
 * 
 * */
public class testPost_apiway2 {

	public static void main(String[] args) throws Exception {		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//---0
		String url = "http://127.0.0.1:8762/api/u/u/test2" ;		//?aaa=123&ffd=我的&dfa=12312wwww
		url= "http://127.0.0.1:8762/dealpost";
		url = "http://127.0.0.1:8762/api/u/u/test2" ;
		HttpPost httpPost = new HttpPost(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEyMzE3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1MDAwMTIyOTcyLCJleHAiOjE0OTU2MDQ5MjJ9.6MBtTb5w15lVnUs33CJAXPdE5sAMFfGW5GNOO2Tye7VdaPtuTatSp1o7E6o2NSmDFfQD1-cx5OaThyQbeh3hoA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTA5Mzc0NzM1MSwiZXhwIjoxNTIxMTAwOTQ3fQ.lCLsCmlDkI6aM-XJyo6r_del_YW6zdGIuYBkKtWELxaG3MNVZDpQita-UEX2w36pbnL6sMIQHGVoDQFK8SlDmg";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTYzMzQwNTY3NCwiZXhwIjoxNTIxNjQwNjA1fQ.2c1RERZUKbyUzz9qDL-88d_q3q-olUWqRfjoNMqYVMYEJeZyhwkuUTwQw7wnzbDXprkhLKgcOzL38bBfTJtIug";
		
		httpPost.setHeader("Authorization", Token);  	
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		

		//-----0
		nvps.add(new BasicNameValuePair("bbb", "测试niah你们那o a我好啊 post123")); 
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps ,"UTF-8"));
	
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
