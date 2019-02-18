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
 

/**
 * 请求解密类 和 token 解析
 * 
 * 	调整加密方案
 * 
 * */
public class Post_queryPostInfo4_Muti {
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 0 ; i< 1 ; i++) {
			
			Post_queryPostInfo4_Muti p = new Post_queryPostInfo4_Muti();
			p.Post_testhellopost_Muti(i);
			System.out.println("执行第"+i+"次");
			System.out.println("-----------");
		}
		
		
	}
	
	/**
	 * 查询 用户参加某个地区的某个活动的
	 * 结果信息
	 * 
	 * 获取token  http://127.0.0.1:8080/user/12
	 * 
	 * 调整加密方案
	 * 
	 * 
	 * */
	public  void Post_testhellopost_Muti(int i) throws Exception {
		System.out.println(new Date());
		
		String  passwd = "testkeysec1"; //ott1201  所对应的密码  testkeysec1
		
		String  url = "http://localhost:8080/testTokenPost";
		url = "http://localhost:8080/api/testTokenPost";
		
		
		//
		
		String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE1NDcwMjQ4ODAyNDAiLCJleHAiOjE1NDcwMjUxODAsImFjY291bnQiOiJhY2NvdW50MSJ9.HCTxgvIO342l6RGW5sU6y3wMrgbbpTxR2oaXRsSFYfk";
		token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE1NDgwNTMxMTgyMDUiLCJleHAiOjE1NDgwNTYxMTgsImFjY291bnQiOiJhY2NvdW50MSJ9.nE6LghEzaGQ0NiUD_M1OKMCpoqTn37h48haDAbdz8x4";
	 //token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE1NDg0MTA5NTgzNzUiLCJleHAiOjE1NDg0MTM5NTgsImFjY291bnQiOiJhY2NvdW50MSJ9.Eav5N29EAH2k6zJF0wa9zlwB2mbXV5VAxfKbw6WB6rk";
		
		String parameters ;
		//实际传参
	    //ott  otname  {"ott":"123","otname":"lllllh"}
		parameters = "{\"ott\":\"123\",\"otname\":\"lllllh\"}"; //需要加密一下
		parameters = "{\"ott\":\"123456\",\"otname\":\"lllllhhh 啊啊 "+i+ "\"}"; //
		//String enstr = AESUtil.decrypt(enstr,clisecret);
		String enstr = AESUtil.encrypt(parameters, passwd);
		//String enstr = SecurityUtil.encryptAESByPasswd(passwd, parameters);		
		parameters = "{ \"cliid\": \"ott1201\",\"enstr\": \""+enstr+"\" }";
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
		httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
		httpPost.setHeader("Accept", "application/json");  
		httpPost.setHeader("Authorization","Bearer "+token);
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
