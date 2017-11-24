package httpPostRequest.tvvas;

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

public class testPost_QueryUserInfo {
	
	
	/**
	 * 《TVVAS APIGW与第三方应用接口规范》
	 * 1.5  查询用户信息
	 * 
	 * json 传值
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		String privateKey = "huangfei";	
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//定义格式，不显示毫秒		 
		String timestampstr = df.format(new Date());
		
		 
		//宽带                         		iptv
		//02202573097          088111116881
		
		String broadbandAccount = "02202573097";
		//String serviceId = "cutv201503182011102";
		String userProvince = "13";
		 
	
		CloseableHttpClient httpclient = HttpClients.createDefault();
	 
		String url = "http://"+ConstanStr.baseurl_zs+"/queryUserInfo" ;
		HttpPost httpPost = new HttpPost(url);	
		
		/**
		 * 
		 * {"serviceId":"cutv201503182510007","source":"1","userProvince":"13","broadbandAccount":""}
		 * { "userProvince":"13","broadbandAccount":"02202573097"}
		 * 
		 * */
		
		String  parameters = "{\"userProvince\": \""+userProvince+"\","
				+ "\"broadbandAccount\": \""+broadbandAccount+"\","
				+ "}";
		System.out.println("url:"+url);
		System.out.println("请求包:"+parameters);		
		
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
