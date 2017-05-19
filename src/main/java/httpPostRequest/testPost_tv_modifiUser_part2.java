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
 * ȫ�汾��  ���¹ؼ��ֶ� 
 * ���� �����û� 2
 * 
 *   tochangeuname
 *   oldpasswd  passwd 
 *   phonenum
 *   
 *   ע�� 
 *   
 *   
 * */
public class testPost_tv_modifiUser_part2 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//---0
		String url = "http://localhost:8080/modifylTvUserUsername" ;
		//---1
		//url="http://localhost:8080/modifylTvUserPasswd";
		//---2
		//url="http://localhost:8080/modifylTvUserPhonenum";
		HttpPost httpPost = new HttpPost(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTExNyIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5NDkzNjI1NTkwMSwiZXhwIjoxNDk1NTQxMDU1fQ.rVcj_ZmoyzdQwF0lWoKMTHX-SOYvYy-g2RNEZQjhzFd9_YgOCWGznYOGDh_h5R3GZX79qEXpI9AZH5Jfxh5WHw";
		httpPost.setHeader("Authorization", Token);  	
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		

		//-----0
		nvps.add(new BasicNameValuePair("tochangeuname", "username12317")); 
		
		//-----1
		//nvps.add(new BasicNameValuePair("oldpasswd", "123456")); 
		//nvps.add(new BasicNameValuePair("passwd", "12345678")); 
		
		//-----2
		//nvps.add(new BasicNameValuePair("phonenum", "112233445611")); 
		
		
		//nvps.add(new BasicNameValuePair("phonenum", ""));
 		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps ,"UTF-8"));
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
