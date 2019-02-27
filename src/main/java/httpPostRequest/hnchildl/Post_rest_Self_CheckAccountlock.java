package httpPostRequest.hnchildl;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.Header;
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


public class Post_rest_Self_CheckAccountlock  {
	
	/**
	 * 自查询 
	 * 	河南 童锁
	 * 校验信息
	 * 
	 * 
	 * */
	public static void main(String[] args) throws Exception {
 
		 
		String  url = "http://127.0.0.1:5081/hn/checkSafetylockSts"     ;
		//{"returncode":0,"returnmsg":"Success","returndesc":"ok","returndata":{"transactionID":"9659620190225172540000000000000000002"}}
		//{"returncode":10004,"returnmsg":"param Err ","returndesc":"请求参数错误","returndata":null}
		//String parameters1 = "{\"productId\":\"hxlmby020@204\" ,\"loginAccount\":\"371654564701732403\"}";
		String parameters1 = "{\"loginAccount\":\"zzlttest70\",\"passwd\":\"1111\"}";
		parameters1 = "{\"loginAccount\":\"zzlttest70\",\"passwd\":\"1err\"}";
		System.out.println(parameters1);
	 	
		 
		
		/**
		 * 活动id promotionid
		 * 
		 * 属主号码,属主地区  ownernumber,ownerarea 
		 * 
		 * 手机号(密文传输，加密方式自定) ,phonenum
		 * 
		 * */		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();	
		HttpPost httpPost = new HttpPost();		
		httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
 
		httpPost.setEntity(new StringEntity(parameters1, Charset.forName("UTF-8")));		
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();  
		    
		    Header headers[] = response2.getAllHeaders();
			int ii = 0;
			while (ii < headers.length) {
				System.out.println(headers[ii].getName() + ":"
						+ headers[ii].getValue());
				++ii;
			}
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println("=="+response2txt);

		} finally {
		    response2.close();
		} 
		
		System.out.println(new Date());
	}
	

}
