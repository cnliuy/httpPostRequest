package httpPostRequest.tvvas;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import httpPostRequest.tools.encryptUtil;

public class testPost_QueryUserJoinedCampaigns {
 
	public static void main(String[] args) {
		 

	}
	
	/**
	 * 1.93.	查询新营销活动接口
	 * 
	 * queryNewCampaigns
	 * 
	 * ---
	 * campaignId	String	O	活动ID（不传查询所有可用活动）
	 * status		String	O	活动状态
	 * 							0	未生效
	 * 							1	已生效
	 * 							不填查询所有
	 * page			Int		M	页码（从1开始）
	 * pageSize		Int		M	每页展示数量
	 * extensionInfo	Map<String,String>	O	扩展信息备用字段
	 * @throws IOException 
	 * @throws ParseException 
	 * 
	 * */
	public static String QueryUserJoinedCampaigns (String url , String sessionId ,String campaignId , 
			String status, int page, int pageSize) throws ParseException, IOException {
		url = url+ "/queryNewCampaigns";
		String response2txt ="";		
		//SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); 
		//String timestampstr = df.format(new Date()); 
		//String serviceId = "cutv201503182011102";
		//	   serviceId="088111116881";			   
		//String userProvince = "13";
		//String type = "2";
		//String outSource = "1";		
		CloseableHttpClient httpclient = HttpClients.createDefault();		 	
		HttpPost httpPost = new HttpPost(url);	
		httpPost.setHeader("Cookie", "JSESSIONID=" + sessionId);	
		System.out.println("JSESSIONID=" + sessionId);
		
		String  parameters = "";
		if( campaignId == null || "".equals(campaignId)) {
			parameters = "{"
					// + "\"campaignId\": \""+campaignId+"\","
					 // + "\"campaignId\": \""+"\","
					+ "\"status\": \""+status+"\","
					+ "\"page\":"+page+","
					+ "\"pageSize\":"+pageSize+""
					+ "}";
		}else {
			parameters = "{\"campaignId\": \""+campaignId+"\","
					+ "\"status\": \""+status+"\","
					+ "\"page\":"+page+","
					+ "\"pageSize\":"+pageSize+""
					+ "}";
			
		}

		
		System.out.println("url:"+url);
		System.out.println("请求   1.93 查询新营销活动接口   (queryNewCampaigns)--  post参数"	+ ":"+parameters);
		
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		//httpPost.setEntity(new StringEntity(jsonString, Charset.forName("UTF-8")));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
		try {		
		    System.out.println(response2.getStatusLine());		    
		    HttpEntity entity2 = response2.getEntity();
		    response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2txt);
		} finally {
		    response2.close();
		}		 
		return response2txt;
	}

}
