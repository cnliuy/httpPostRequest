package httpPostRequest;

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
 * 全版本的Post 
 * 
 * 统计资费和
 * 
 * */
public class testPost_cs_findExpensesCountNumtByIds {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		//-------------------------------------http://localhost:8080/adduser------------------------------
		HttpPost httpPost = new HttpPost("http://localhost:8080/findExpensesTypeCountNumtByIds");
		httpPost = new HttpPost("http://localhost:8080/findapplicationlistByIds");
		
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwMzY0NTg1MTgyOSwiZXhwIjoxNTA0MjUwNjUxfQ.4i_EXUKWNESruqtO9BMK9i2msusQZIETgbP1ADcQHsA6xeom9V6ZULJQMzk3W8KYFAAYr98KclkqIEni6lW52A";
		httpPost.setHeader("Authorization", Token);  
		
		String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";
		parameters = "{\"username\":\"username7中文输入1\",\"password\":\"123456\"}";
		parameters = "{\"username\":\"+862285971073\",\"password\":\"bbb721713210ae4d1f590a6641039a29\"}";		
		parameters = "{\"ids\":\"2,3,4\"}";
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		//httpPost.setEntity(new HttpEntity);setRequestEntity(new StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    //System.out.println(response2.getStatusLine());
		    System.out.println(response2txt);
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    //EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}


	}

}
