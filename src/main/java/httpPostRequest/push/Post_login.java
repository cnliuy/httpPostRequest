package httpPostRequest.push;

import java.nio.charset.Charset;
import java.util.ArrayList;
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

public class Post_login {
	

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://localhost:8080/login");
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		//String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwMzM5NjYzNjIxMywiZXhwIjoxNTA0MDAxNDM2fQ.cO4NK45XLsS7b4EspYa_v2p00Ty87eDU6m0OiEuoUay_EORZBa1jCFskAnnlTCRHvu--hJHznP3WgUYpENC39Q";
		//httpPost.setHeader("Authorization", Token);  
		
		String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";
		
		parameters = "{\"username\":\"admin1\",\"password\":\"password\"}";
		//parameters = "{\"username\":\"admin1\",\"password\":\"$2a$10$3DYbbsL94OFlV6McoKS8V./E7oT5p9bTeMymmWPeUB3wo7wX0kssC\"}";
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		//httpPost.setEntity(new HttpEntity);setRequestEntity(new StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
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

		/**
		 * Authorization:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEiLCJleHAiOjE1MzUwMTI3NjJ9.x1PTw0tezY5EMvgrk9UJRygu0lrZgLoTr5v57iqiXT6Oh9X5-ON_yYt0QTjHWUcZQxIgmxpta-mkbV0QibXuEA
X-Content-Type-Options:nosniff
X-XSS-Protection:1; mode=block
Cache-Control:no-cache, no-store, max-age=0, must-revalidate
Pragma:no-cache
Expires:0
X-Frame-Options:DENY
Content-Length:173
Date:Wed, 22 Aug 2018 08:26:02 GMT
{ "Authorization":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEiLCJleHAiOjE1MzUwMTI3NjJ9.x1PTw0tezY5EMvgrk9UJRygu0lrZgLoTr5v57iqiXT6Oh9X5-ON_yYt0QTjHWUcZQxIgmxpta-mkbV0QibXuEA"}

		 * 
		 * */
	}
	

}
