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
 * 测试 新建群组
 * 
 *    groupname
 *    weight
 *    groupicontype
 *   
 *   注意 
 *   
 *   
 * */
public class testPost_tv_addGroup {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//---0
		String url = "http://localhost:8080/addGroup" ;
		//---1
		//url="http://localhost:8080/modifylTvUserPasswd";
		//---2
		//url="http://localhost:8080/modifylTvUserPhonenum";
		HttpPost httpPost = new HttpPost(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEyMzE3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1MDAwMTIyOTcyLCJleHAiOjE0OTU2MDQ5MjJ9.6MBtTb5w15lVnUs33CJAXPdE5sAMFfGW5GNOO2Tye7VdaPtuTatSp1o7E6o2NSmDFfQD1-cx5OaThyQbeh3hoA";
		httpPost.setHeader("Authorization", Token);  	
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		

		//-----0
		nvps.add(new BasicNameValuePair("groupname", "祖名5")); 
		//nvps.add(new BasicNameValuePair("weight", "3")); 
		//nvps.add(new BasicNameValuePair("groupicontype", "66"));  		
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
