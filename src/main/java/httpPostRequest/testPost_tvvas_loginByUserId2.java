package httpPostRequest;

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
import org.apache.http.client.methods.HttpPut;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 *  
 * 测试  TV vas 
 * test OK
 * 
 * 用户查询的接口规范,可以查询到用户的消费记录和订购记录
 *  	http://202.99.114.62:35825/PORTAL/dsm    测试地址
 * */
public class testPost_tvvas_loginByUserId2 {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String methodname = "loginByUserId";
		String url = "http://202.99.114.62:35825/PORTAL/dsm/"+methodname ;
		HttpPost httpPost = new HttpPost(url);		

		String  parameters = "{\"userId\":\"tjlt001\","
						+ "\"mac\":\"7497812C8C81\",\"carrierId\":\"201\",\"lang\":\"zh\","
						+ "\"model\":\"EC6108V9U_pub_tjjlt\",\"ip\":\"60.29.181.145\","
						+ "\"osVersion\":\"4.4.4\",\"area\":\"12\"}";
		
		 
		parameters = "{\"userId\":\"sdlt001\",\"password\":\"sdlt001\",\"mac\":\"00446885424B\",\"carrierId\":\"204\",\"lang\":\"zh\",\"model\":\"EC6108V9_pub_hnylt\",\"ip\":\"192.168.1.6\",\"osVersion\":\"4.4.4\",\"area\":\"12\"}";
		parameters = "{\"userId\":\"sdlt001\",\"mac\":\"60EB69930CB2\"}";
		parameters = "{\"userId\":\"tjlt002\",\"mac\":\"60EB69930CB2\"}";
		parameters = "{\"userId\":\"tjlt012\",\"mac\":\"60EB69930CB2\"}";
		/**
		 * 
		 *  宽带                         iptv
		 *  02201457871          02201457871
		 *  02202573097          088111116881
		 * 
		 * */
		
		
		parameters = "{\"userId\":\"088111116881\",\"mac\":\"60EB69930CB2\"}";
		
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		

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
