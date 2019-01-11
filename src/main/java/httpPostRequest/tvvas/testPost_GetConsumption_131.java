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

public class testPost_GetConsumption_131 {
 
	public static void main(String[] args) {
		 

	}
	
	/**
	 * 1.31.	查询用户历史消费记录
	 * 
	 * getConsumption
	 * 
	 *
	 * 用户在应用商城apk自服务页面查看消费历史记录，方法名称为“getConsumption” 请求消息体
	 * 
	 * spId			O	String(32)	增值业务SP 的编号(保留字段，暂时查询全量的消费记录)
	 * month		M	String(12)	所查用户消费记录的月份(格式为“YYYYMM”)
	 * lang			O	String(12)	语种
	 * 							不传表示使用系统默认语种
	 * orderMode	O	String(20)	1：金额订购
	 * 								2：IPTV积分订购
	 * 								3：电信积分订购
	 * 								4：赠送帐户现金订购
	 * 								5：赠送帐户积分订购
	 * 								6：虚拟游戏币消费
	 * 								7：虚拟游戏币充值
	 * 								20：第三方支付
	 * 								56:支付宝支付
	 * 								如果该字段为空，则需要返回所有订购模式的消费记录。
	 * Page		Int		M	页码
	 * pageSize		Int	M	每页展示项目数量
	 * 
	 * ---
	 * @throws IOException 
	 * @throws ParseException 
	 * 
	 * */
	public static String goGetConsumption (String url , String sessionId ,
			String spId ,    
			String month, 
			String orderMode,  int page, int pageSize) throws ParseException, IOException {
		
		url = url+ "/getConsumption";
		String response2txt ="";		

		CloseableHttpClient httpclient = HttpClients.createDefault();		 	
		HttpPost httpPost = new HttpPost(url);	
		httpPost.setHeader("Cookie", "JSESSIONID=" + sessionId);	
		System.out.println("JSESSIONID=" + sessionId);
		
		String  parameters = "{";
		
		//if( spId == null || "".equals(spId)) {			
		//}else {
			parameters = parameters+  "\"spId\":\""+spId+"\"," ;
		//}
		
		
		
		if( month == null || "".equals(month)) {			
		}else {
			parameters = parameters+  "\"month\":\""+month+"\"," ;
		}
		//System.out.println(parameters);
		
		//if( orderMode == null || "".equals(orderMode)) {			
		//}else {
			parameters = parameters+  "\"orderMode\":\""+orderMode+"\"," ;
		//}
		
		
		if( orderMode == null || "".equals(orderMode)) {			
		}else {
			parameters = parameters+  "\"orderMode\":\""+orderMode+"\"," ;
		}
		
		if( page <0) {			
		}else {
			parameters = parameters+  "\"page\":"+page+" ," ;
		}
		
		if(  pageSize <0) {			
		}else {
			parameters = parameters+  "\"pageSize\":"+ pageSize+" " ;
		}
		
		parameters += "}";
		
	 

		
		System.out.println("url:"+url);
		System.out.println("请求   1.31.  查询用户历史消费记录   (getConsumption)--  post参数"	+ ":");
		System.out.println("   "+parameters);
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
