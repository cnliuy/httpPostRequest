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
 * 测试  TV vas 
 * 
 * 用户查询的接口规范,可以查询到用户的消费记录和订购记录
 *  	http://202.99.114.62:35825/PORTAL/dsm    测试地址
 * */
public class testPost_tvvas_loginByUserId3 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String methodname = "loginByUserId";
		String url = "http://202.99.114.62:35825/PORTAL/dsm/"+methodname ;
		HttpPost httpPost = new HttpPost(url);		

		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		
		//nvps.add(new BasicNameValuePair("userId", "02204194613"));  
		nvps.add(new BasicNameValuePair("userId", "tjlt001"));		
		nvps.add(new BasicNameValuePair("mac", "7497812C8C81")); 
		
		String privateKey = "The HMAC private key";
		String data ="{\"appId\":\"98726189\"}";
		String singstring = HMACSHA256Sign.sign(privateKey,data);
		System.out.println("<"+singstring+">");	 
		//--httpPost.setHeader("signature", singstring);  
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
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
