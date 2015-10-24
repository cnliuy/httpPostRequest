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
 * 测试 更新用户 全流程
 * */
public class testPost_updateUser2 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://123.59.78.43:8080/lr/api/v1/usertools/updateuser?username=15802238232&digest=f6364126029045522b9a3dc0937ec26106bbe0d3" ;
		HttpPost httpPost = new HttpPost(url);		
//		HttpPut httpPut = new HttpPut("http://localhost/lr/api/v1/usertools/"
//				+ "updateuser?username=user007&digest=e60e633cd564e24bcc4bcf91b1c3d7ccb9966d9a");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		
		nvps.add(new BasicNameValuePair("loginName", "15802238232")); //关键值 必须有  非空键值  填完并不做验证 但是需要填写		
		nvps.add(new BasicNameValuePair("name", "15802238232"));//关键值 必须有  非空键值
		nvps.add(new BasicNameValuePair("password", "admin"));
		nvps.add(new BasicNameValuePair("phonenumber", "15802238232"));		
		nvps.add(new BasicNameValuePair("university", "%E5%A4%A9%E6%B4%A5%E5%A4%A7%E5%AD%A6&"));
		nvps.add(new BasicNameValuePair("universityId", "1"));
		nvps.add(new BasicNameValuePair("subjectId", "1"));
		nvps.add(new BasicNameValuePair("subject", "通信工程学院"));
		nvps.add(new BasicNameValuePair("years", "2011"));
		nvps.add(new BasicNameValuePair("years", "2011"));
		nvps.add(new BasicNameValuePair("yearsId", "1"));
		//nvps.add(new BasicNameValuePair("_method", "put"));		
		nvps.add(new BasicNameValuePair("captchacode", "0000"));		
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
