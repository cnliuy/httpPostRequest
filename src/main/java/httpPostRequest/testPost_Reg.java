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
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 全版本的Post 
 * 测试 注册流程
 * */
public class testPost_Reg {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();


		//-------------------------------------http://localhost:8080/lr/api/v1/userregister------------------------------
		
		//HttpPost httpPost = new HttpPost("http://localhost:8080/lr/task/create?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3&writesess=23");
		HttpPost httpPost = new HttpPost("http://localhost/lr/api/v1/userregister/");
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();

		nvps.add(new BasicNameValuePair("loginName", "user007"));
		nvps.add(new BasicNameValuePair("name", "user007"));
		nvps.add(new BasicNameValuePair("password", "111111"));
		nvps.add(new BasicNameValuePair("phonenumber", "15522214561"));
		nvps.add(new BasicNameValuePair("captchacode", "5123"));		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
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
