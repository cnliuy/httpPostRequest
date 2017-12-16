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

public class testPost_GetConsumption {
	
	
	/**
	 * 1.27 获取用户消费记录接口
	 * 
	 * json 传值
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		String privateKey = "huangfei";	
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//定义格式，不显示毫秒		 
		String timestampstr = df.format(new Date());
		
		//sha256(<private key>+< serviceId>+<userProvince>+< month >+< outSource >+<timestamp>)+<timestamp>
		//timestamp是14


		String serviceId = "cutv201503182011102";
		   	   serviceId="088111116881";
		   	   serviceId="02200141763" ;
		String userProvince = "13";
		String month = "201708";
		String outSource = "1";
		
		serviceId = "053901806146";	   	  
	    userProvince = "17";
	    month = "201608";
	      
		serviceId = "088111864369";	   	  
	    userProvince = "13";
	    month = "201709";
		 
//		serviceId = "02200141763";	   	  
//	    userProvince = "13";
//	    month = "201709";
	    
	    
		String message = serviceId+userProvince+month+outSource;
		
		String sign = "";
		try {
			sign = encryptUtil.messageSign(message, privateKey, timestampstr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sign = "12312312111111232131231231231231";  //校验是否需要真的签名
		CloseableHttpClient httpclient = HttpClients.createDefault();
	 
		//String url = "http://202.99.114.62:10000/getConsumption" ;
		String url = "http://"+ConstanStr.baseurl_zs+"/getConsumption" ;
		HttpPost httpPost = new HttpPost(url);	
		
		/**
		 * {
		    "serviceId": "cutv201503182011102",
		    "userProvince": "13",
		    "month": "201711",
		    "outSource": "1",
		    "signature": "2cff827d164f05e7e36f3ceb5e8c337fe710bcced8134566a6ba15512e557d2120171110153700",
		    "spId": "",
		    "orderMode": ""
		}
		 * */
		
		String  parameters = "{\"serviceId\":\""+serviceId+"\","
				+ "\"userProvince\": \""+userProvince+"\","
				+ "\"month\": \""+month+"\","
				+ "\"outSource\": \""+outSource+"\","
				+ "\"signature\": \""+sign+"\","
				+ "\"spId\": \"\","
				+ "\"orderMode\": \"\","
				+ "}";
		System.out.println("url:"+url);
		System.out.println("请求包:"+parameters);
		 
    	//parameters = "{\"userId\":\"088111116881\",\"mac\":\"60EB69930CB2\"}";
		
		
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
