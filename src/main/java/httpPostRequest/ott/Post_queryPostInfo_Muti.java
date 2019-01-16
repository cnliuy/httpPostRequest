package httpPostRequest.ott;

import java.nio.charset.Charset;
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


public class Post_queryPostInfo_Muti {
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 0 ; i< 1 ; i++) {
			
			Post_queryPostInfo_Muti p = new Post_queryPostInfo_Muti();
			p.Post_testhellopost_Muti();
			System.out.println("执行第"+i+"次");
			System.out.println("-----------");
		}
		
		
	}
	
	/**
	 * 查询 用户参加某个地区的某个活动的
	 * 结果信息
	 * 
	 * 
	 * */
	public  void Post_testhellopost_Muti() throws Exception {
		System.out.println(new Date());
		String  url = "http://localhost:8080/testhellopost";
		url = "http://localhost:8080/testhellopost";
		
		String parameters = "{\"useri\":\"adminadminadminadminadmin\"}";
		parameters = "{\"upromotionresultinfo\":\"3SJbNr38GewUpnmrkon92\"}";
		 
		System.out.println(parameters);
	 	 
		
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

		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		
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
		    System.out.println(response2txt);

		} finally {
		    response2.close();
		} 
		
		System.out.println(new Date());
	}
	

}
