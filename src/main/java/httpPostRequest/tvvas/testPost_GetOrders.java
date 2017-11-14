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

public class testPost_GetOrders {
	
	
	/**
	 * 1.26 	��ȡ�Ѷ�����Ʒ�б�ӿ�
	 * 
	 * json ��ֵ
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		String privateKey = "huangfei";	
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//�����ʽ������ʾ����		 
		String timestampstr = df.format(new Date());
		
		//sha256(<privgetConsumption
		//<serviceId>+<userProvince>+<type >+<outsource > 
		//timestamp��14
		String serviceId = "cutv201503182011102";
		String userProvince = "13";
		String type = "2";
		String outSource = "1";
		
		 
		String message = serviceId+userProvince+type+outSource;
		
		String sign = "";
		try {
			sign = encryptUtil.messageSign(message, privateKey, timestampstr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//sign = "12312312111111232131231231231231";  //У���Ƿ���Ҫ���ǩ��
		CloseableHttpClient httpclient = HttpClients.createDefault();
	 
		String url = "http://202.99.114.62:10000/getOrders" ;
		HttpPost httpPost = new HttpPost(url);		

		String  parameters = "{\"serviceId\": \""+serviceId+"\","
				+ "\"userProvince\": \""+userProvince+"\","
				+ "\"type\": \""+type+"\","
				+ "\"outSource\": \""+outSource+"\","
				+ "\"signature\": \""+sign+"\"}";
		
		 
    	//parameters = "{\"userId\":\"088111116881\",\"mac\":\"60EB69930CB2\"}";
		System.out.println("url:"+url);
		System.out.println("�����:"+parameters);
		
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
