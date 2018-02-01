package httpPostRequest;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class test_tvyyt_checksingleorder {

	public static void main(String[] args) throws Exception {
		 
	     
			String url = "http://127.0.0.1:6088/checkSingleOrder" ;
			url = "http://60.29.181.148:6088/checkSingleOrder" ;
			url = "http://127.0.0.1:6088/checkSingleOrder" ;
			
			HttpPost httpPost = new HttpPost(url);				
			CloseableHttpClient httpclient = HttpClients.createDefault();
			
			//{sign=fSMzwZ3nAwky0hxOvUg/eUvGwmJ5pSn6LhbddmpACks=, result=0B0000, area=010, 
			//orderNo=100230501061801252002479990332, phoneType=03, responseType=02, 
			//money=1, number=78578147, resultDesc=交费成功, reqNo=1338924}

			 
			httpPost.addHeader("Content-Type","application/json; charset=utf-8");
 
			Timestamp now = new Timestamp(System.currentTimeMillis());   
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");   
			String str = df.format(now); 
			
			String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";
			parameters = "{\"reqNo\":\"1339735\",\"channelCode\":\"501\",\"timeStamp\":\""+str+"\"}";
 
			
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
			System.out.println("-------------------"+new Date()+"------------------------------------------");
	
			
			
			
			
			
			
			
			
			
			
		 


	}

}
