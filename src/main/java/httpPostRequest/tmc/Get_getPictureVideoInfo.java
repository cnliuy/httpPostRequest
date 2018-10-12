package httpPostRequest.tmc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Get_getPictureVideoInfo {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjUiLCJhdWRpZW5jZSI6IndlYiIsImNyZWF0ZWQiOjE1MDI3NjU3Njk1MDQsImV4cCI6MTUwMzM3MDU2OX0.umHXGAVggBrjfMi8rzZuj1IIcXd2_Q8upGT04tVvtaoFP_DYEA-fHq96fSjTAlDVIRr3rMua0E2w9jtY6fZ5tA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMDkzNTY1ODk5NywiZXhwIjoxNTIwOTQyODU4fQ.gBW7Sm0FSGnOtja0SwSH-APTynF0NiQJ2sUaTrM2QA_vHwbuzz5WjDX3T5KiDUV2Nz8WJCKHenUTBvVkZSEO_w";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTA3ODAxMTUxNSwiZXhwIjoxNTIxMDg1MjExfQ.Y0GKThYwmgKgIT9z_Iux6SE5zzDUJEflqXQxU2sxh0OX93HXfl-gmVt0JDbueiyc7c_5-KC01CNVXzN4QnTfUA";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTA5Mzc0NzM1MSwiZXhwIjoxNTIxMTAwOTQ3fQ.lCLsCmlDkI6aM-XJyo6r_del_YW6zdGIuYBkKtWELxaG3MNVZDpQita-UEX2w36pbnL6sMIQHGVoDQFK8SlDmg";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTE5ODYyMjA5NSwiZXhwIjoxNTIxMjA1ODIyfQ.M3Lfq1kfsUwCTV8jAbEfRgYb5I_xLSf3JvbBynvT8y2sX_9rGEl8jnscAWwteFh2IWqjhG7wgF-QEt7QqXoTEw";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUyMTYxMDMyNTQ0MSwiZXhwIjoxNTIxNjEwNDI1fQ.cvGPo7ez4C--4vrdi9dZeEm2NwhD1cLGtizv4Fv_xRk44CAug9IT2NXWmIcsKQG8sJGfHr94W0LnRmvpwA7bCQ";
		Token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxMjM0NTYxMjM0NTYxMjM0NTZfMTU2MjAwMTE2MjAiLCJleHAiOjE1MzkzMjAxODF9.8L7dWdNRWfTmMvzz5MO7lTaHrtbhW4pROWSfJlsazhN1JAuhS30KgIQT_3d32kO9lKpOeXnZKvwKwM7PeyydzA";
		
		
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://127.0.0.1:8762/api/u/u/test" ;
		
		url = "http://211.94.218.245:9080/getPictureVideoInfo?id=21" ;
		HttpGet httpget = new HttpGet(url);		
		

		Token = "token-"+Token;
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
