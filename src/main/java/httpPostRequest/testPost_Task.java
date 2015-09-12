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
public class testPost_Task {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpGet httpGet = new HttpGet("http://localhost:8080/lr/task/create?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3&writesess=23");
//		CloseableHttpResponse response1 = httpclient.execute(httpGet);
//		// The underlying HTTP connection is still held by the response object
//		// to allow the response content to be streamed directly from the network socket.
//		// In order to ensure correct deallocation of system resources
//		// the user MUST call CloseableHttpResponse#close() from a finally clause.
//		// Please note that if response content is not fully consumed the underlying
//		// connection cannot be safely re-used and will be shut down and discarded
//		// by the connection manager. 
//		try {
//		    System.out.println(response1.getStatusLine());
//		    //Cookie[] cookies=httpGet..getState().getCookies();
//		    HttpEntity entity1 = response1.getEntity();
//		    // do something useful with the response body
//		    // and ensure it is fully consumed
//		    EntityUtils.consume(entity1);
//		} finally {
//		    response1.close();
//		}

		//-------------------------------------http://localhost:8080/lr/task/create------------------------------
		
		//HttpPost httpPost = new HttpPost("http://localhost:8080/lr/task/create?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3&writesess=23");
		HttpPost httpPost = new HttpPost("http://localhost:8080/lr/api/v1/task/create?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3&writesess=23");
		
		//HttpPost httpPost = new HttpPost("http://localhost:8080/lr/task/create");
		//id=&title=222&description=222&gender=%E7%94%B7%E6%80%A7&jobType=%E5%85%A8%E8%81%8C&timeRquirement=222&district=%E5%92%8C%E5%B9%B3&paymentCalcWay=%E5%B0%8F%E6%97%B6&payment=222&jobRequirements=222&phoneCall=222
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		//nvps.add(new BasicNameValuePair("username", "admin"));
		//nvps.add(new BasicNameValuePair("digest", "f6364126029045522b9a3dc0937ec26106bbe0d3"));
		//nvps.add(new BasicNameValuePair("writesess", "23"));
		nvps.add(new BasicNameValuePair("id", ""));
		nvps.add(new BasicNameValuePair("title", "090909012343"));
		nvps.add(new BasicNameValuePair("description", "111111"));
		nvps.add(new BasicNameValuePair("gender", "男性"));
		nvps.add(new BasicNameValuePair("jobType", "兼职"));
		nvps.add(new BasicNameValuePair("timeRquirement", "111111"));
		nvps.add(new BasicNameValuePair("district", "111111"));
		nvps.add(new BasicNameValuePair("paymentCalcWay", "小时"));
		nvps.add(new BasicNameValuePair("payment", "11111111"));
		nvps.add(new BasicNameValuePair("phoneCall", "小时"));
		nvps.add(new BasicNameValuePair("jobRequirements", "1"));
		
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
