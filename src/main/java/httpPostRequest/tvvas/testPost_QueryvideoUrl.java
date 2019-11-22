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

public class testPost_QueryvideoUrl {
 
	public static void main(String[] args) {
		 

	}
	
	/**
	 * 1.37.	获取视频播放路径
	 * 接口功能
	 * 
	 * 视频点播和4K的APK客户端，根据内容ID、对接的IPTV厂商平台等信息，获取实际播放的视频源地址“queryVideoURL”
	 * 
	 * carrierId	String	M	运营商编号
	 * type			String	M	视频分类
	 * 							1：表示视频点播
	 * 							2：表示4k视频
	 * 
	 * contentId	String	M	内容编号
	 * tvPlatform	String	M	IPTV平台的厂商类型
	 * 								1：中兴
	 * 								2：烽火
	 * 								3：华为
	 * 								4：快乐微视
	 * 								0：ALL 标识查询所有平台的播放地址
	 * 
	 * */
	public static String QueryvideoUrl (String url , String sessionId , //默认参数
			String carrierId , String type, String  contentId, String tvPlatform) throws ParseException, IOException {
		url = url+ "/queryvideoUrl";
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
	 
		parameters = "{"
					// + "\"campaignId\": \""+campaignId+"\","
					 // + "\"campaignId\": \""+"\","
					+ "\"carrierId\": \""+carrierId+"\","
					+ "\"type\":\""+type+"\","
					+ "\"contentId\":\""+contentId+"\","
					+ "\"tvPlatform\":\""+tvPlatform+"\","
					+ "}";
		 

		
		System.out.println("url:"+url);
		System.out.println("请求   1.37.	获取视频播放路径 queryvideoUrl --  post参数"	+ ":"+parameters);
		
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
