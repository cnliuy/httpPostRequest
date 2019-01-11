package httpPostRequest.tvvas;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import httpPostRequest.tools.encryptUtil;

public class testGet_GetTvHallConfig_1_96 {
 
	public static void main(String[] args) {
		 

	}
	
	/**
	 * 1.96.	获取电视营业厅配置信息接口
	 * 
	 * getConsumption
	 * 
	 *
	 * 获取电视营业厅配置信息
		方法名称为“getTvHallConfig”

	 * 
	 * ---
	 * @throws IOException 
	 * @throws ParseException 
	 * 
	 * */
	public static String GetTvHallConfig (String url , String sessionId ) throws ParseException, IOException {
		
		url = url+ "/getTvHallConfig";
		String response2txt;
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		
		httpget.setHeader("Cookie", "JSESSIONID=" + sessionId);	
		System.out.println("JSESSIONID=" + sessionId);

		CloseableHttpResponse response2 = httpclient.execute(httpget);
		try {

			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			response2txt = EntityUtils.toString(entity2);
			System.out.println(" 1.96  接口 getTvHallConfig 返回值:"+response2txt);

		} finally {
			response2.close();
		}
		
		return response2txt;
	
	}

}
