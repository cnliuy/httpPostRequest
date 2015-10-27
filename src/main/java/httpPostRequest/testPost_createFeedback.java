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
 * 全版本的Post 
 * 测试 更新反馈全流程
 * */
public class testPost_createFeedback {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://localhost:8080/lr/api/v1/usertools/createfeedback?username=7add6c21f9934cdaac631d16e6eafc49&digest=f6364126029045522b9a3dc0937ec26106bbe0d3" ;
		HttpPost httpPost = new HttpPost(url);		

		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		
		nvps.add(new BasicNameValuePair("contents", "contentscontentscontents"));  
		nvps.add(new BasicNameValuePair("useremail", "15802238232@111.com")); 
		nvps.add(new BasicNameValuePair("userphonenum", "15802238232"));

		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		//httpPut.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
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
