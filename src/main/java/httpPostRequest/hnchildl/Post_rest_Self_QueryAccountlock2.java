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


public class Post_rest_Self_QueryAccountlock2  {
	
	/**
	 * 自查询    加密
	 * 	河南 童锁
	 * 结果信息
	 * 
	 * 
	 * */
	public static void main(String[] args) throws Exception {
 
		 
		String  url = "http://127.0.0.1:5081/hn/querySafetylockSts"     ;
		//{"returncode":0,"returnmsg":"Success","returndesc":"ok","returndata":{"transactionID":"9659620190225172540000000000000000002"}}
		//{"returncode":10004,"returnmsg":"param Err ","returndesc":"请求参数错误","returndata":null}
		
		String loginAccount ="zzlttest70"; //371654564701732403
	
		String appid = "cp0001";
		String appkey = "trtret";
		String time = "20190226142325";
		String productId = "hxlmby020@204";
		
		String sign = MD5_1.md5(appkey+time);
		System.out.println(appkey+time );
		
		String parameters1 = "{\"productId\":\"hxlmby020@204\" ,\"loginAccount\":\"371654564701732403\"}";
		parameters1 = "{\"loginAccount\":\""+loginAccount+"\",\"productId\":\""+productId+"\",\"appId\":\""+appid+"\",\"time\":\""+time+"\",\"sign\":\""+sign+"\"}";
		
		//String parameters1 = "{\"productId\":\"hxlmby020@204\" ,\"loginAccount\":\"\"}";
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
