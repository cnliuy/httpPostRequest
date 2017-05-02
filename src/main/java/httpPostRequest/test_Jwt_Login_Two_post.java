package httpPostRequest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 测试 JWT登陆 2 
 * 
 * 模拟客户端提交 token  通过Post方式
 * 
 * 
 * @author LY
 * {@value}
 * 
 * 返回值：
 * */
public class test_Jwt_Login_Two_post {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/");	
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5MzcyMTMxODYyNiwiZXhwIjoxNDk0MzI2MTE4fQ.sOTwltpjjPvjqrPXFCzlLn0ugOUuVfrkadkgvGi1A-h4oeSW1VGsJ9wFX_n1jISSZ90U7tOBPZA3PiRo9WGBVg";
		//httpPost.addHeader("Authorization",Token);
		httpPost.setHeader("Authorization", Token);  		
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2.getStatusLine());
		    System.out.println(response2txt);
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    //EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}

	}

}
