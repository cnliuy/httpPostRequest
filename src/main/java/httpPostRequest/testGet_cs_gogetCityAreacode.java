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
 *  获取 areacode  通过 cityid
 * */
public class testGet_cs_gogetCityAreacode {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://60.29.181.148:5080/livingcircle?lctype=1" ;
		url = "http://127.0.0.1:6080/gogetAreaCodeByCityid?cityid=414" ; //414
		HttpGet httpget = new HttpGet(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrZnVzZXIwMSIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMjIwMzE1NzQxMCwiZXhwIjoxNTIyODA3OTU3fQ.wazi37OJdfPUXK0Rlwk2ZyEx-TKJgYwX_vxhn-P1yRZRkRv08yze1Q-xkK6CA7JpHthSB0ZccG1GAw5MBEtp0g";
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
