package httpPostRequest.tvbss;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
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

/**
 * 新建活动
 * 
 * */
public class Post_goAddPromotionByArea {
	

	public static void main(String[] args) throws Exception {
		
		String  url = "http://localhost:6280/goAddPromotionByArea";
		
		   url = "http://202.99.114.63:18023/goAddPromotionByArea"; //zs
		
		
		String parameters = "{\"promotioni\":\"adminadminadminadminadmin\"}";
		parameters = "{\"promotioni\":\"3SJbNr38GewUpnmrkon92g==\"}";  //后面会被覆盖
		
		/**
		 *  	
	int val; //权重  越大越后 起始值 100
	String areacode; //对应owernarea
	String numbertype;	
	int startday;
	int endday;	
	int startyear;
	int endyear;	
	int startmonth;
	int endmonth;		
	 
	Date startdate; 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date enddate; 
	private String promotionid;//活动编码 区号-起始时间-活动简称 022-20181022142312-jdcx
	private String promotionname; //活动名称
	private String promotiondesc; //活动描述1 
	private String promotiondesc2;//活动描述2 
	private String promotiondesc3;//活动描述3 
	private String promotiondesc4;//活动描述4 
	private String promotiondesc5;//活动描述5 
		 * 
		 * */
		
		//usercount 活动人数
		
		parameters = "{\"val\":\"100\",\"areacode\":\"022\",\"numbertype\":\"0\", \"usercount\":0,"
				+ "\"startday\":10,\"endday\":30,\"startyear\":2018,\"endyear\":2018,"
				+ "\"startmonth\":10,\"endmonth\":10,"
				+ "\"startdate\":\"2018-10-10 12:11:12\",\"enddate\":\"2018-10-20 12:11:12\","
				+ "\"promotionid\":\"022-20181022142312-jdcx\",\"promotionname\":\"活动名称0\"}";
		
		parameters = "{\"val\":\"101\",\"areacode\":\"022\",\"numbertype\":\"0\", \"usercount\":2,"
				+ "\"startday\":10,\"endday\":30,\"startyear\":2018,\"endyear\":2018,"
				+ "\"startmonth\":10,\"endmonth\":10,"
				+ "\"startdate\":\"2018-10-10 12:11:12\",\"enddate\":\"2018-10-20 12:11:12\","
				+ "\"promotionid\":\"022-20181022142312-jdcx1\",\"promotionname\":\"活动名称1\"}";
		
		parameters = "{\"val\":\"101\",\"areacode\":\"022\",\"numbertype\":\"0\", \"usercount\":2,"
				+ "\"startday\":10,\"endday\":30,\"startyear\":2018,\"endyear\":2018,"
				+ "\"startmonth\":10,\"endmonth\":10,"
				+ "\"startdate\":\"2018-10-10 12:11:12\",\"enddate\":\"2018-10-20 12:11:12\","
				+ "\"promotionid\":\"022-20181022142312-jdcx2\",\"promotionname\":\"活动名称2\"}";
		
		/**
		 * 需把日期和时间调对
		 *    字符中的也要对应好
		 * 
		 * 注重配置 promotionid 不能重复  和 日期 
		 * 
		 * */
		parameters = "{\"val\":\"101\",\"areacode\":\"010\",\"numbertype\":\"0\", \"usercount\":1,"  //可用的用户数
				+ "\"startday\":28,\"endday\":1,"
				+ "\"startyear\":2018,\"endyear\":2018,"
				+ "\"startmonth\":11,\"endmonth\":12,"
				+ "\"startdate\":\"2018-11-28 12:11:12\","
				+ "\"enddate\":\"2018-12-01 23:59:59\","
				+ "\"promotionid\":\"0101-20181129010101-jdzs1\",\"promotionname\":\"北京活动1\"}";
		
		
	 	String encrypted = AESUtil.encrypt(parameters);
		
		parameters = "{\"promotioni\":\""+encrypted+"\"}";
		
		/**
		 * 活动id promotionid
		 * 
		 * 充值号码,充值地区,号码类别, numstr,areacode,numberType,
		 * 
		 * 属主号码,属主地区,属主类型 ownernumber,ownerarea,ownertype,
		 * 
		 * 时间精确到秒(20181022142312), 金额(分), 手机号（密文传输，加密方式自定） date,fee,phonenum
		 * */
		
		
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();	
		HttpPost httpPost = new HttpPost();		
		httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		//String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJpZFwiOjMsXCJwaG9uZW51bVwiOlwiMTIzNDU2Nzg5MTFcIixcInVzZXJjYXJkaWRcIjpcIjM2Mjg2NjE5OTkwOTIzXCIsXCJ1c2VybmFtZVwiOlwiMzYyODY2MTk5OTA5MjNfMTIzNDU2Nzg5MTFcIixcInVzZXJvdGlkXCI6MyxcInVzZXJ0eXBlXCI6XCIxXCJ9IiwiZXhwIjoxNTM4MjE1MzU3fQ.W1cJFgpXLgRcjIAwgLbzQUYeJhI7Dhi1jMOn75R-BTKOSKsRNMuMKKRoQEscugfuurznVROZJPJK9R1HtlYhkQ";
		//httpPost.setHeader("Authorization", "token-"+ Token);  
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
		 * 
		 * 
		 * */
	}
	

}
