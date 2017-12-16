package httpPostRequest;



import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
 * 
 * 批量发起 结单
 * 发起退费 
 * 
 * 批量 结单  ----
 * 
 * 
 * */
public class testGet_cs_procesCompleteSimpleTask2 {

	public static void main(String[] args) throws Exception {
		//
		// 选取 退费的id数
		//
		//  SELECT '"',id ,'",' FROM public.cus_workorder
		//  where cus_workorder.workordersts = '发起退费' order by id;
		//
		
		String[] strArray={
				"27605",
				
	 
			
	

		};
		
		for(int i=0;i<strArray.length;i++){		
			System.out.println("ok s -"+new Date());
			CloseableHttpClient httpclient = HttpClients.createDefault();
			String url = "http://60.29.181.148:5080/livingcircle?lctype=1" ;		
			//url = "http://127.0.0.1:6080/completeThisPersonalTaskByBussinessId?woId=5150" ;
			url = "http://127.0.0.1:6080/completeThisPersonalTaskByBussinessId?woId="+strArray[i] ;
			//url = "http://202.99.114.136:10015/completeThisPersonalTaskByBussinessId?woId="+strArray[i] ;
			
			//SELECT id ,workordernum ,workordersts FROM public.cus_workorder where cus_workorder.workordersts = '发起退费';
	
			//SELECT * FROM public.cus_workorder where id = 404
			
			//SELECT id ,workordernum ,workordersts,* FROM public.cus_workorder where cus_workorder.workordersts = '发起退费';
			
			HttpGet httpget = new HttpGet(url);			
			String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUxMjAzNDI0NjU1MiwiZXhwIjoxNTEyNjM5MDQ2fQ.M6W4jfX8u0nPhu-IpNc-s8MQC2flhzwHxog3LIqnkAxgGWsms2cQOBqx1zU-NhAcXVh_-F3AEVQmP6XmORbJdQ";
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
			    //TimeUnit.SECONDS.sleep(3);
			    for(int hs =0 ;hs <900000;hs++){
			    	int kk =(1+1)*12;	
			    	long s =1*2*3*3*4*4*48*12+1-123-123-123-123;
			    }
			    System.out.println("ok e -"+new Date());
			}
		}
		

	}

}
