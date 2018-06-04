package httpPostRequest.epg;

import java.nio.charset.Charset;
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
import httpPostRequest.tools.encryptUtil;

public class testPost_EPG_1 {
	
	
	/**
	 * 带转发的 返回body中 添加 
	 *  TVVAS APIGW EPG
	 *  
	 * 	http://localhost:5080/tigerDraw/enter.html?userId=088111116881&carrierId=204&returnUrl=***
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		String privateKey = "huangfei";			
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//  
		String timestampstr = df.format(new Date());		 
		//���                         		iptv
		//02202573097          088111116881
		
		String broadbandAccount = "02202573097";
		broadbandAccount = "053901803259";
		broadbandAccount = "02200141763";
		
		//String serviceId = "cutv201503182011102";
		String userProvince = "13";
		userProvince = "13";
		 
	
		CloseableHttpClient httpclient = HttpClients.createDefault();
	 
		String url = "http://localhost:5080/api/PORTAL/dsm/loginByUserId?userId=088111116881&carrierId=204&needturn=1&newurl=http://202.99.114.26:35826&returnUrl=http://202.99.114.26:35826" ;//&returnUrl=202.99.114.25:35827
		HttpPost httpPost = new HttpPost(url);	
		
//		String  parameters = "{\"userProvince\": \""+userProvince+"\","
//				+ "\"broadbandAccount\": \""+broadbandAccount+"\","
//				+ "}";
		String url11 ="http://202.99.114.26:35826";
		String  parameters = "{\"needturn\": \"1\","
		+ "\"newurl\": \""+url11+"\","
		+ "}";
		System.out.println("url11:"+url11);
		 
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		

		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
		try {
			
		    System.out.println(response2.getStatusLine());		    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2txt);

		} finally {
		    response2.close();
		}

	}
	

}
