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
 * 全版本的Post 
 * 测试 更新用户 3
 * 
 *   appsts	   电视用户=100  , 手机用户 >200 , android 210 , ios 310 
 *   birthday  形式：  yyyy-MM-dd 
 *   clientversion
 *   deviceId  设备号
 *   gender    性别： 男 \女
 *   nickname
 *   osId  设备类型 ：  IOS ,Android ,TV
 * 	 province  所在省份
 *   city  所在市
 *   truename    
 *   tvaccount
 *   useremail
 *   usersource
 *   usertype   tv, ios, anroid
 *   wechatopenid
 *   
 *   注意  省份 和城市 在 表中 需要有  需要有 很重要 
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
		//nvps.add(new BasicNameValuePair("gender", "男")); 
		//nvps.add(new BasicNameValuePair("nickname", "nickname118")); 
		nvps.add(new BasicNameValuePair("osId", "TV")); 
		nvps.add(new BasicNameValuePair("province", "天津")); 
		nvps.add(new BasicNameValuePair("city", "天津"));
		//nvps.add(new BasicNameValuePair("truename", "真实姓名"));
		//nvps.add(new BasicNameValuePair("tvaccount", "tvaccount TV账号"));
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
