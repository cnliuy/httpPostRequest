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
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 流程测试 test
 * 
 * 发起退费 
 * 
 * 
 * */
public class testGet_cs_procesCompleteSimpleTask {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://60.29.181.148:5080/livingcircle?lctype=1" ;

		//String[] strArray={"1","2","3"};
		//for(int i=0;i<strArray.length;i++)
		
		url = "http://127.0.0.1:6080/completeThisPersonalTaskByBussinessId?woId=5150" ;
		url = "http://127.0.0.1:6080/completeThisPersonalTaskByBussinessId?woId=501" ;
		//SELECT id ,workordernum ,workordersts FROM public.cus_workorder where cus_workorder.workordersts = '发起退费';

		//SELECT * FROM public.cus_workorder where id = 404
		
		//SELECT id ,workordernum ,workordersts,* FROM public.cus_workorder where cus_workorder.workordersts = '发起退费';
		
		HttpGet httpget = new HttpGet(url);	
		
		
		
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUxMjAzMDU4ODE0NywiZXhwIjoxNTEyNjM1Mzg4fQ.D7ynjjDA-U5R86P1MNTH7o8rkSxTVslAKPS6oDoVwdKS4eNplivdPziqR9BMkisk6LKfV799Fv37qzT6oa6E0Q";
		httpget.setHeader("Authorization", Token); 	
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();		


		CloseableHttpResponse response2 = httpclient.execute(httpget);
		//CloseableHttpResponse response2 = httpclient.execute(httpPut);
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
