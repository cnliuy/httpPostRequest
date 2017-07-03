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
 * 测试 douban
 * 
 *  		
 *     
 *    
 *   
 *    
 *   
 *   
 * */
public class testGet_douban {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "https://www.douban.com/search?q=天下无贼" ; 
 	    //String  s = "?usernumber=+8643182640058&osId=3&module=60400&operateType=01&opresource=消息&provinceid=205&" 
 	    //		+ "osVersion=4.4.4&appType=WJSX_TV&appVer=V1.0.2.200";
 	    url =url;
		HttpGet httpget = new HttpGet(url);		 
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
