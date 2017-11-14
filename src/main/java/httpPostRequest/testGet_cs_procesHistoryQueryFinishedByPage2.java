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
 * Á÷³Ì²âÊÔ test
 * 
 * 
 * 
 * */
public class testGet_cs_procesHistoryQueryFinishedByPage2 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://60.29.181.148:5080/livingcircle?lctype=1" ;

		url = "http://127.0.0.1:6080/queryHistoricInstanceByPage?page=0" ;
		HttpGet httpget = new HttpGet(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwMzY0NTg1MTgyOSwiZXhwIjoxNTA0MjUwNjUxfQ.4i_EXUKWNESruqtO9BMK9i2msusQZIETgbP1ADcQHsA6xeom9V6ZULJQMzk3W8KYFAAYr98KclkqIEni6lW52A";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5eXVzZXIiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE1MDM5MDY1OTYxMzAsImV4cCI6MTUwNDUxMTM5Nn0.bLWMMWipjkz6frBM6eA_ntLH1Jg3D3WzZZjfVo2-pbBZIrWyA5MXsgYKGfzoXSK78dSFzGRStO2ihSX7a0op-g";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjc3VzZXIiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE1MDQ4NjQ0OTY4MzksImV4cCI6MTUwNTQ2OTI5Nn0.3zjyTt_0tzkZaDDQtGcvs4NJQLeWpCb7fNSBOGAxecBXLDaphbPMhkbhj5nnwlUDciYjLBV6lgMfFIBbVgQ64w";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrZnVzZXIwMSIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwNTM3NDAzNTMzOCwiZXhwIjoxNTA1OTc4ODM1fQ.apnUzb6-IbsNkI2aCgLnr0trrovsUJ2iv6GJPcFKLsNOp3sLYMiLAWwTWvhNH0orLW6nRYETRs9nNzllvPjmpA";

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
