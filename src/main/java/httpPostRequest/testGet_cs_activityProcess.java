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
 * ¼¤»îÁ÷³Ì
 * 
 * 
 * */
public class testGet_cs_activityProcess {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://60.29.181.148:5080/livingcircle?lctype=1" ;
		url = "http://127.0.0.1:8080/startprocess?woId=200" ;
		HttpGet httpget = new HttpGet(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjUiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE1MDI3NjU3Njk1MDQsImV4cCI6MTUwMzM3MDU2OX0.umHXGAVggBrjfMi8rzZuj1IIcXd2_Q8upGT04tVvtaoFP_DYEA-fHq96fSjTAlDVIRr3rMua0E2w9jtY6fZ5tA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjUiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE1MDI5MDA5MzE3MDUsImV4cCI6MTUwMzUwNTczMX0.eYrGdjNdQPasAdCld_raYmY2mVtmDdLRNBs0lU1_WSt9rYTzHrooAOeS6idFYrn7NIw8w3ze0otyIIQTvTWe2A";
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
