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
 * 流程测试 test
 * 
 * 
 * 
 * */
public class testGet_cs_procesCompleteMutiTask {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://60.29.181.148:5080/livingcircle?lctype=1" ;
		/**
		 *调整1  (含 网关)
		zjcl  直接处理
		returngz  返回之前的故障操作


		 * 
		 * */
		url = "http://127.0.0.1:8080/completeThisPersonalTaskByBussinessIdAndTostat?woId=5150&nextnode=returngz" ; //调整1  返回到故障
		url = "http://127.0.0.1:8080/completeThisPersonalTaskByBussinessIdAndTostat?woId=5150&nextnode=zjcl" ; //调整1  直接处理
		
		HttpGet httpget = new HttpGet(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwMzY0NTg1MTgyOSwiZXhwIjoxNTA0MjUwNjUxfQ.4i_EXUKWNESruqtO9BMK9i2msusQZIETgbP1ADcQHsA6xeom9V6ZULJQMzk3W8KYFAAYr98KclkqIEni6lW52A";
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
