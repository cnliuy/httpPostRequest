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
 * ȫ�汾��Post 
 * ���� �����û� 3
 * 
 *   appsts	   �����û�=100  , �ֻ��û� >200 , android 210 , ios 310 
 *   birthday  ��ʽ��  yyyy-MM-dd 
 *   clientversion
 *   deviceId  �豸��
 *   gender    �Ա� �� \Ů
 *   nickname
 *   osId  �豸���� ��  IOS ,Android ,TV
 * 	 province  ����ʡ��
 *   city  ������
 *   truename    
 *   tvaccount
 *   useremail
 *   usersource
 *   usertype   tv, ios, anroid
 *   wechatopenid
 *   
 *   ע��  ʡ�� �ͳ��� �� ���� ��Ҫ��  ��Ҫ�� ����Ҫ 
 *   
 *   
 * */
public class testPost_tv_modifiUser_part1 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://localhost:8080/modifylTvUser" ;
		HttpPost httpPost = new HttpPost(url);		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1bmFtZTExOCIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5NDkyMjk5Mjk2NywiZXhwIjoxNDk1NTI3NzkyfQ.PHm0tsqfwSEHKhX9-cCjdN_dOfIpW7w2AMX4ncxADbkPvMm7feeoLIpeunaDrYF4I2B7mg73VjLp87g4QtFLog";
		httpPost.setHeader("Authorization", Token);  	
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		
		//nvps.add(new BasicNameValuePair("uname", "uname109"));  	
		//nvps.add(new BasicNameValuePair("passwd", "passwd1"));
		//nvps.add(new BasicNameValuePair("phonenum", "userPhonenum123"));
		
		nvps.add(new BasicNameValuePair("appsts", "100")); 
		nvps.add(new BasicNameValuePair("birthday", "1988-08-08")); 
		nvps.add(new BasicNameValuePair("clientversion", "clientversion123")); 
		nvps.add(new BasicNameValuePair("deviceId", "deviceId123")); 
		nvps.add(new BasicNameValuePair("gender", "��1")); 
		nvps.add(new BasicNameValuePair("nickname", "�Ұ���")); 
		nvps.add(new BasicNameValuePair("osId", "TV")); 
		nvps.add(new BasicNameValuePair("province", "���")); 
		nvps.add(new BasicNameValuePair("city", "���"));
		nvps.add(new BasicNameValuePair("truename", "��ʵ����"));
		nvps.add(new BasicNameValuePair("tvaccount", "tvaccount TV�˺�"));
		nvps.add(new BasicNameValuePair("useremail", "123@163.com"));
		nvps.add(new BasicNameValuePair("usersource", "usersourceIP"));
		nvps.add(new BasicNameValuePair("usertype", "tv"));
		nvps.add(new BasicNameValuePair("wechatopenid", "1231231"));
		
	
		
		
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
