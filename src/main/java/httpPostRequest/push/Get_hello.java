package httpPostRequest.push;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Get_hello {
	

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpGet httpGet = new HttpGet("http://localhost:8080/hello");
		httpGet.addHeader("Content-Type","application/json; charset=utf-8");
		httpGet.setHeader("Accept", "application/json");  
		String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEiLCJleHAiOjE1MzUwMTUwODN9.08pliX5tZe3WYk3ZfCqK7JLOA_fL5Jj7dEnLDXYQinnD3iieB20ZaJRYXMXddIGJL8DGPu7MKFrXHihoUunWgQ";
		httpGet.setHeader("Authorization", Token);  
		

		
		 	
		//httpPost.setEntity(new HttpEntity);setRequestEntity(new StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
		CloseableHttpResponse response2 = httpclient.execute(httpGet);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2txt);

		} finally {
		    response2.close();
		}


	}
	

}
