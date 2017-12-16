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
 * 
 *  当前任务查询
 *  
 *  	http://127.0.0.1:6080/gogetTasksByAssigneeAndUsername   测试地址
 * */
public class testPost_tvvas_gogetTasksByAssigneeAndUsername {

	public static void main(String[] args) throws Exception {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String methodname = "gogetTasksByAssigneeAndUsername";
		String url = "http://127.0.0.1:6080/"+methodname ;
		HttpPost httpPost = new HttpPost(url);		

		String parameters = "{\"uname\":\"金小钰\",\"assignee\":\"admin\"}";				

		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);		   
		    System.out.println(response2txt);		   
		} finally {
		    response2.close();
		}
	}

}
