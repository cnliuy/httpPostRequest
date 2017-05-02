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
 * 测试 JWT登陆 1 
 * 
 * 模拟客户端提价参数  通过Post方式
 * 
 * http://yunjiechao-163-com.iteye.com/blog/1490796
 * 
 * HttpClient 模拟 ajax 提交
 * 
 * @author LY
 * {@value}
 * 
 * 返回值：
 *  HTTP/1.1 200 
 *  {
 *  	"token" : "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5MzcyMTMxODYyNiwiZXhwIjoxNDk0MzI2MTE4fQ.sOTwltpjjPvjqrPXFCzlLn0ugOUuVfrkadkgvGi1A-h4oeSW1VGsJ9wFX_n1jISSZ90U7tOBPZA3PiRo9WGBVg"
 *  }
 * */
public class test_Jwt_Login {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/auth");		
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";

		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		//httpPost.setEntity(new HttpEntity);setRequestEntity(new StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
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
