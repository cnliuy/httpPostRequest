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
import org.apache.http.protocol.HTTP;
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
public class testPost_tv_addUser_full {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://localhost:8080/addFullTvUser" ;
		 url = "http://localhost:5080/addFullTvUser" ;
		 url = "http://60.29.181.148:5080/addFullTvUser" ;
		 
		HttpPost httpPost = new HttpPost(url);		

		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		
		nvps.add(new BasicNameValuePair("uname", "lytesttj123456"));  	
		nvps.add(new BasicNameValuePair("passwd", "password123"));
		//nvps.add(new BasicNameValuePair("phonenum", "userPhonenum118"));		
		nvps.add(new BasicNameValuePair("appsts", "100")); 
		//nvps.add(new BasicNameValuePair("birthday", "1988-08-08")); 
		nvps.add(new BasicNameValuePair("clientversion", "clientversion127")); 
		nvps.add(new BasicNameValuePair("deviceId", "deviceId117")); 
		//nvps.add(new BasicNameValuePair("gender", "��")); 
		//nvps.add(new BasicNameValuePair("nickname", "nickname118")); 
		nvps.add(new BasicNameValuePair("osId", "TV")); 
		nvps.add(new BasicNameValuePair("province", "���")); 
		nvps.add(new BasicNameValuePair("city", "���"));
		//nvps.add(new BasicNameValuePair("truename", "��ʵ����"));
		//nvps.add(new BasicNameValuePair("tvaccount", "tvaccount TV�˺�"));
		//nvps.add(new BasicNameValuePair("useremail", "123@163.com"));
		//nvps.add(new BasicNameValuePair("usersource", "usersourceIP"));
		nvps.add(new BasicNameValuePair("usertype", "tv"));
		//nvps.add(new BasicNameValuePair("wechatopenid", "1231231"));
		
	
		
		
		//nvps.add(new BasicNameValuePair("phonenum", ""));
		  
		httpPost.setEntity(new UrlEncodedFormEntity(nvps ,"UTF-8")  );
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
