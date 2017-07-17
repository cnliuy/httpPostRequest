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
 * 测试 新建模块访问日志
 * 
 *  		
 *     
 *    
 *   
 *    
 *   
 *   
 * */
public class testGet_tv_addLog {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//---0		http://60.29.181.148:5080/
		String url = "http://60.29.181.148:5080/wjsxOperationLog" ; 
		 url = "http://127.0.0.1:5080/wjsxOperationLog" ; 
 	    String  s = "?usernumber=+8643182640058&osId=3&module=60400&operateType=01&opresource=消息&provinceid=205&" 
 	    		+ "osVersion=4.4.4&appType=WJSX_TV&appVer=V1.0.2.200";
 	    url =url+s;
		HttpGet httpget = new HttpGet(url);		 
		//List <NameValuePair> nvps = new ArrayList <NameValuePair>();		

		//-----0
//		nvps.add(new BasicNameValuePair("usernumber", "+8643182640058")); 
//		nvps.add(new BasicNameValuePair("osId", "3")); 
//		nvps.add(new BasicNameValuePair("module", "60400"));  	
//		nvps.add(new BasicNameValuePair("operateType", "01"));  
//		nvps.add(new BasicNameValuePair("Opresource", "消息"));  
//		//nvps.add(new BasicNameValuePair("cityid", ""));  
//		nvps.add(new BasicNameValuePair("provinceid  ", "1"));  
//		nvps.add(new BasicNameValuePair("osVersion", "4.4.4"));  
//		nvps.add(new BasicNameValuePair("appType", "WJSX_TV"));  
//		nvps.add(new BasicNameValuePair("appVer", "V1.0.2.200"));  
		//httpget.setParams(params);(new UrlEncodedFormEntity(nvps ,"UTF-8"));
		//httpPut.setEntity(new UrlEncodedFormEntity(nvps));
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
