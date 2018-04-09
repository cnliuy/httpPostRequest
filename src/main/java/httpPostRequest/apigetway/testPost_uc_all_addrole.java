package httpPostRequest.apigetway;

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
 *  新增角色
 * 
 * 
 * */
public class testPost_uc_all_addrole {

	public static void main(String[] args) throws Exception {		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//---0
		String url = "http://127.0.0.1:8762/api/u/u/test2" ;		//?aaa=123&ffd=我的&dfa=12312wwww
		url= "http://127.0.0.1:8762/dealpost";
		url = "http://127.0.0.1:8763/api/u/u/test3" ;
		url = "http://127.0.0.1:8763/addRole" ;
		
		url = "http://127.0.0.1:8090/api/u/addRole" ;
		
		HttpPost httpPost = new HttpPost(url);	
		
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEyMzE3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1MDAwMTIyOTcyLCJleHAiOjE0OTU2MDQ5MjJ9.6MBtTb5w15lVnUs33CJAXPdE5sAMFfGW5GNOO2Tye7VdaPtuTatSp1o7E6o2NSmDFfQD1-cx5OaThyQbeh3hoA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTU0MzQzNjg4OSwiZXhwIjoxNTIxNTUwNjM2fQ.m9oMNC83aFDeYugjyyI1UR1d41mDSXOtPNgo1b-161lM81Osrab5cWApkndpG-BNZ7ktf9KmIYdUfOhgwVqmOg";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMzI2MTExOTYwOCwiZXhwIjoxNTIzMjY4MzE5fQ.oRwywDiWU0LxOgpS_tIdsOomu6g6sEQkFsvDVRGjfN05XkoMuxFIrl6rKP2nZJ4uAotwE8HOUV3pFoBXZrNFTw";
		
		httpPost.setHeader("Authorization", Token);  	 
		
		
		String parm = "rolename2";
		String parm2 = "角色描述";
		String parm3 = "";	   
		
 
		String  parameters = "{\"rolename\":\""+parm+ "\",\"roledesc\":\""+parm2+"\",\"vorder\":\""+parm3+"\" }";
		
		System.out.println(parameters);
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
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
