package httpPostRequest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class test_tvyyt_callback {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost("http://60.29.181.148:6088/callbackUrl");
		 httpPost = new HttpPost("http://127.0.0.1:6088/callbackUrl");
		 //httpPost = new HttpPost("https://t2.unicompayment.com/NpfMobilePayfeeWeb/acs.do");
		// httpPost = new HttpPost("http://127.0.0.1:6088/acsoooo");
		// httpPost = new HttpPost("http://60.29.181.148:6088/acs.do");
		// httpPost = new HttpPost("http://127.0.0.1:6088/acs.do");	
		// httpPost = new HttpPost("http://60.29.181.148:6088/acs.do");	
		 
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("sign", "jVKXHgC3ndqNEmLjsIx7pix4nxeq7P1a5AZEn3TNdOc="));
		nvps.add(new BasicNameValuePair("result", "0B0000"));
		nvps.add(new BasicNameValuePair("area", "010"));
		nvps.add(new BasicNameValuePair("orderNo", "100230501071801231839489990187"));
		nvps.add(new BasicNameValuePair("phoneType", "03"));
		nvps.add(new BasicNameValuePair("responseType", "02"));
		nvps.add(new BasicNameValuePair("money", "1"));
		nvps.add(new BasicNameValuePair("number", "78578147"));
		nvps.add(new BasicNameValuePair("resultDesc", "交费成功"));
		nvps.add(new BasicNameValuePair("reqNo", "1338862"));
		nvps.add(new BasicNameValuePair("extend", ""));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps ,"UTF-8"));
		//httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2.getStatusLine());
		    System.out.println(response2txt);
		} finally {
		    response2.close();
		}


	}

}
