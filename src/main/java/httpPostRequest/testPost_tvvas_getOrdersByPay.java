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
 * ����  TV vas 
 * ��ȡ�Ѿ���������Ʒ
 * 
 * */
public class testPost_tvvas_getOrdersByPay {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String methodname = "getOrdersByPay";
		String url = "http://202.99.114.62:35825/PORTAL/dsm/"+methodname ;
		HttpPost httpPost = new HttpPost(url);		

		String  parameters;
		
		parameters = "{\"page\":\"1\",\"pageSize\":\"10\"}";
		
		String sessionId = "4AB6CE44467A70F6E6EB32CED010CFE8";
		sessionId = "AECEF9A973465AE38522AD71B1B4FB7D";
		sessionId = testPost_tvvas_SessionId.SessionId;
		//String userToken = "0E41A9B0616132F78E699C0BBE7C3230";
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		//httpPost.setHeader("sessionId", sessionId); 
		//httpPost.setHeader("userToken", userToken); 
		//httpPost.setHeader("Cookie", "JSESSIONID=" + DSMGlobal.sessionId);
		httpPost.setHeader("Cookie", "JSESSIONID=" + sessionId);
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
