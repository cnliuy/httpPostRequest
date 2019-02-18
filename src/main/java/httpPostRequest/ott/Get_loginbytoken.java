package httpPostRequest.ott;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 通过token 过验证
 * @author ly
 *
 */
public class Get_loginbytoken {
	//获取token  http://127.0.0.1:8080/user/12
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String tokens ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE1NDcwMjQ4ODAyNDAiLCJleHAiOjE1NDcwMjUxODAsImFjY291bnQiOiJhY2NvdW50MSJ9.HCTxgvIO342l6RGW5sU6y3wMrgbbpTxR2oaXRsSFYfk";
		tokens = 
"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZU1pbGxpcyI6IjE1NDc3MTg3MDIxNDYiLCJleHAiOjE1NDc3MjE3MDIsImFjY291bnQiOiJhY2NvdW50MSJ9.ZSdSbHHxP1PAQ30jtj7xG2vEvvFqxkdIm9naYdHhwi0";
		String url = "http://127.0.0.1:8080/";  
		url = "http://127.0.0.1:8080/api/queryAccount?numstr=031800177748&areacode=0318&phoneType=03";
		url = "http://127.0.0.1:8080/api/testGetUsername?uu=12456";
		
		for(int i =0 ;i<1 ;i++) {
		 Get_loginbytoken.loginbytoken(url,tokens);
		 System.out.println("----------第 "+i+" 次");
		}
	}
	
	
	public static void loginbytoken(String url ,String token ) throws ClientProtocolException, IOException  {
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		httpget.addHeader("Content-Type","application/json; charset=utf-8");
		httpget.setHeader("Accept", "application/json");  
		httpget.setHeader("Authorization","Bearer "+token);

		CloseableHttpResponse response2 = httpclient.execute(httpget);
		try {

			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			String response2txt = EntityUtils.toString(entity2);
			System.out.println(response2txt);

		} finally {
			response2.close();
		}
		
	}
		





}
