package httpPostRequest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 测试 JWT登陆 2 
 * 
 * 模拟客户端提交 token  通过get方式
 * 
 * 
 * @author LY
 * {@value}
 * 
 * 返回值：
 * 
 *    见下面
 * */
public class test_Jwt_Login_Two_get {

	public static void main(String[] args) throws Exception {	
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
        String url = "http://127.0.0.1:8080/persons";      //1
       // url = "http://127.0.0.1:8080/protected";         //2  需要 Admin 权限
        

       
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
		String Token =  
		"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTfkuK3mlofovpPlhaUxIiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDkzODg4NDI0MTA5LCJleHAiOjE0OTQ0OTMyMjR9.ZAzILWNQrdctZoa0kGVpzKtMjJATMnvZCj0f_5jpHNjCvEa5FLk166DFCmnj0dn1IL2yGpO0tjhRU9q7ksgH11";//MA
		//httpPost.addHeader("Authorization",Token);
		httpGet.setHeader("Authorization", Token);    
        
        
		CloseableHttpResponse response2 = httpclient.execute(httpGet);
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
	
	
	/**
	 * 1.  error
		HTTP/1.1 401 
		{
		  "timestamp" : 1493724041951,
		  "status" : 401,
		  "error" : "Unauthorized",
		  "message" : "Unauthorized",
		  "path" : "/persons"
		}
		
		2. error
		HTTP/1.1 401 
		{
		  "timestamp" : 1493724180700,
		  "status" : 401,
		  "error" : "Unauthorized",
		  "message" : "Unauthorized",
		  "path" : "/protected"
		}
		
		--------------------------		
		1. ok
	    
		HTTP/1.1 200 
		[ {
		  "name" : "Hello",
		  "email" : "World"
		}, {
		  "name" : "Foo",
		  "email" : "Bar"
		} ]
		
		2.ok
		
		
		HTTP/1.1 200 
		Greetings from admin protected method!

	 */

}
