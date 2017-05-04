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
 * 
 * 测试任务
 * 
 * */
public class testPost_modifyTvUser {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		//-------------------------------------http://localhost:8080/lr/task/create------------------------------
		HttpPost httpPost = new HttpPost("http://localhost:8080/modifyTvUser");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("userName", "wolf2"));
		nvps.add(new BasicNameValuePair("userPhonenum", "1555555556"));
		nvps.add(new BasicNameValuePair("tvAccount", "122222"));
//		nvps.add(new BasicNameValuePair("gender", "男性"));
//		nvps.add(new BasicNameValuePair("jobType", "兼职"));
//		nvps.add(new BasicNameValuePair("timeRquirement", "111111"));
//		nvps.add(new BasicNameValuePair("district", "111111"));
//		nvps.add(new BasicNameValuePair("paymentCalcWay", "小时"));
//		nvps.add(new BasicNameValuePair("payment", "11111111"));
//		nvps.add(new BasicNameValuePair("phoneCall", "小时"));
//		nvps.add(new BasicNameValuePair("jobRequirements", "1"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);

		try {
			
		    System.out.println(response2.getStatusLine());
		    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2txt);
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    //EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}

	}

}
