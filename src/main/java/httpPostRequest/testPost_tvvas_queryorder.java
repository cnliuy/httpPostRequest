package httpPostRequest;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
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
 * Tv vas
 * 
 *   ¶©µ¥×´Ì¬²éÑ¯  1.34
 * 
 * 
 * -------------------Wed Oct 11 19:33:41 CST 2017------------------------------------------
 * {"result":"990000","payTradeID":"1122434","tradeID":"1122434","resultDesc":"sucess11193311","authenticator":"ygpqGA9Rf4Xs8jgGR7/M9bJkkGTrC1uEsSvyrZxRVX0="}
 * -------------------Wed Oct 11 19:33:59 CST 2017------------------------------------------
 * 
 * 
 * */
public class testPost_tvvas_queryorder {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		//-------------------------------------http://localhost:8080/adduser------------------------------
		System.out.println("-------------------"+new Date()+"------------------------------------------");
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/queryTvOrderStatus");
		httpPost = new HttpPost("http://202.99.114.136:10021/queryTvOrderStatus");
		
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		//httpPost.setHeader("Accept", "application/json");  
		//String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwMzM5NjYzNjIxMywiZXhwIjoxNTA0MDAxNDM2fQ.cO4NK45XLsS7b4EspYa_v2p00Ty87eDU6m0OiEuoUay_EORZBa1jCFskAnnlTCRHvu--hJHznP3WgUYpENC39Q";
		//httpPost.setHeader("Authorization", Token);  
		
		String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";
		parameters = "{\"sessionId\":\"sessionId\",\"orderId\":\"orderId4\",\"areaCode\":\"###\",\"fee\":10}";
		
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
		System.out.println("-------------------"+new Date()+"------------------------------------------");


	}

}
