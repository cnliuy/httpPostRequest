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
 * 参考：
 * http://yunjiechao-163-com.iteye.com/blog/1490796 * 
 * HttpClient 模拟 ajax 提交
 * http://blog.csdn.net/majian_1987/article/details/47728769 *
 * HttpClient 通过 Post 方式发送Json数据
 * 
 * @author LY
 * {@value}
 * 
 * 返回值：
 *  HTTP/1.1 200 
 *  {
 *  	"token" : "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5MzcyMzU1NzY2MywiZXhwIjoxNDk0MzI4MzU3fQ.XHaVeL94443uQk3Uy0IdV3DHA10woYqxKYeG4e4Z8fb1qTmXtZy-4oko8R_jyhWtRldYL11i6jbCpDQCfHDERQ"
 *  }
 * */
public class test_Jwt_Login {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://60.29.181.148:5080/auth");		
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";
		parameters = "{\"username\":\"username7中文输入1\",\"password\":\"123456\"}";
		parameters = "{\"username\":\"uname111\",\"password\":\"passwd1\"}";
		parameters = "{\"username\":\"+863162429007\",\"password\":\"75c1cba116f090411cea83b19ea716d9\"}";
		parameters = "{\"username\":\"+862285971073\",\"password\":\"bbb721713210ae4d1f590a6641039a29\"}";
		
		
		parameters = "{\"username\":\"uname117\",\"password\":\"passwd1\"}";
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		//httpPost.setEntity(new HttpEntity);setRequestEntity(new StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    //System.out.println(response2.getStatusLine());
		    System.out.println(response2txt);
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    //EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}

	}

}
