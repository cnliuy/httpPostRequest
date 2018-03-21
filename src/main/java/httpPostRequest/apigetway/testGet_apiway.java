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
 *  
 * 
 * 
 * */
public class testGet_apiway {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://127.0.0.1:8762/api/u/u/test" ;
		url = "http://127.0.0.1:8762/api/u/u/test" ;
		url = "http://127.0.0.1:8762/api/u/u/test?aaa=123你即好&ffd=我的&dfa=12312wwww" ;
		HttpGet httpget = new HttpGet(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjUiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE1MDI3NjU3Njk1MDQsImV4cCI6MTUwMzM3MDU2OX0.umHXGAVggBrjfMi8rzZuj1IIcXd2_Q8upGT04tVvtaoFP_DYEA-fHq96fSjTAlDVIRr3rMua0E2w9jtY6fZ5tA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMDkzNTY1ODk5NywiZXhwIjoxNTIwOTQyODU4fQ.gBW7Sm0FSGnOtja0SwSH-APTynF0NiQJ2sUaTrM2QA_vHwbuzz5WjDX3T5KiDUV2Nz8WJCKHenUTBvVkZSEO_w";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTA3ODAxMTUxNSwiZXhwIjoxNTIxMDg1MjExfQ.Y0GKThYwmgKgIT9z_Iux6SE5zzDUJEflqXQxU2sxh0OX93HXfl-gmVt0JDbueiyc7c_5-KC01CNVXzN4QnTfUA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTA5Mzc0NzM1MSwiZXhwIjoxNTIxMTAwOTQ3fQ.lCLsCmlDkI6aM-XJyo6r_del_YW6zdGIuYBkKtWELxaG3MNVZDpQita-UEX2w36pbnL6sMIQHGVoDQFK8SlDmg";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTE5ODYyMjA5NSwiZXhwIjoxNTIxMjA1ODIyfQ.M3Lfq1kfsUwCTV8jAbEfRgYb5I_xLSf3JvbBynvT8y2sX_9rGEl8jnscAWwteFh2IWqjhG7wgF-QEt7QqXoTEw";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTYxMDMyNTQ0MSwiZXhwIjoxNTIxNjEwNDI1fQ.cvGPo7ez4C--4vrdi9dZeEm2NwhD1cLGtizv4Fv_xRk44CAug9IT2NXWmIcsKQG8sJGfHr94W0LnRmvpwA7bCQ";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTYzMzQwNTY3NCwiZXhwIjoxNTIxNjQwNjA1fQ.2c1RERZUKbyUzz9qDL-88d_q3q-olUWqRfjoNMqYVMYEJeZyhwkuUTwQw7wnzbDXprkhLKgcOzL38bBfTJtIug";
		
		
		httpget.setHeader("Authorization", Token);  
		//httpget.setHeader("access-token", Token);  
		
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
