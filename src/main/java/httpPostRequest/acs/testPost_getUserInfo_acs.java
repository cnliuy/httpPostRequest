package httpPostRequest.acs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import httpPostRequest.tools.encryptUtil;

public class testPost_getUserInfo_acs {
 
	public static void main(String[] args) throws ParseException, IOException {
		/**
		 * acs 正式地址
		 * 
		 * */
		String url = "http://202.99.114.14:35820/ACS/vas/";   //acs  正式地址
		
		String userId = "cutv201711272010101";//085209004332
		userId = "cutv085209004332";
		
		String ss = testPost_getUserInfo_acs.getUserInfo_acs(url, userId);
		System.out.println(ss);

	}
	
	/**
	 * 3.14 获取用户基本信息（HTTP+JSON）
	 * 
	 * 第三方VAS系统向TV VAS管理系统请求获取用户基本信息接口，后台返回数据库中的用户信息。
	 * 
	 * 接口原型
	 * 	接口地址：http://[ip]:[port]/ACS/vas/getUserInfo 
	 * 
	 * 属性			必选	数据类型(字节)	名称						说明
	 * userToken	O	String(32)	业务管理平台为该用户分配的临时	身份证明	
	 * userId		M	String(36)	IPTV 用户业务编号			必填字段
	 * 
	 * @throws IOException 
	 * @throws ParseException 
	 * 
	 * */
	public static String getUserInfo_acs (String url , 
			String userId  ) throws ParseException, IOException {
		url = url+ "/getUserInfo";
		String response2txt ="";		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();		 	
		HttpPost httpPost = new HttpPost(url);	
		//httpPost.setHeader("Cookie", "JSESSIONID=" + sessionId);	
		//System.out.println("JSESSIONID=" + sessionId);
		
		String  parameters = "";
		if( userId == null || "".equals(userId)) {

		}else {	
			parameters = "{"
					+ "\"userId\": \""+userId+"\""				 
					+ "}";
			System.out.println(parameters );
		}

		
		System.out.println("url:"+url);
		System.out.println("请求   3.14 获取用户基本信息   (getUserInfo)--  post参数"	+ ":"+parameters);
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
	
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
		try {		
		    System.out.println(response2.getStatusLine());		    
		    HttpEntity entity2 = response2.getEntity();
		    response2txt=EntityUtils.toString(entity2);
		    //System.out.println(response2txt);
		} finally {
		    response2.close();
		}		 
		return response2txt;
	}

}
