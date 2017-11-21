package httpPostRequest.tvvas.td;

import java.net.InetAddress;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import httpPostRequest.tools.GogetLocalMac;
import httpPostRequest.tools.encryptUtil;

public class testPost_tvvas_tvstore_login {
	
	private final Log logger = LogFactory.getLog(this.getClass());
	
	
	/**
	 *  1.1  登录
	 * 
	 * <TV VAS V100R001C05 TV Store和客户端接口规范--内部接口.docx>
	 * 
	 * json 传值
	 * 	loginByUserId
	 * 
	 *      测试账号：
	 * 		userId 088111116881
	 * 		mac
	 * 		carrierId  201
	 * 
	 * 	http://202.99.114.62:35825/PORTAL/dsm
	 * 
	 * */
//	public static void main(String[] args) throws Exception {
//		
//		String baseUrl =Tvvas_Constant.BaseUrl;
//		
//		Tvvasuser tu = new Tvvasuser();
//		String userId = "088111116881";
//		String carrierId = "201";
//		//获取本机mac地址
//		InetAddress ia = InetAddress.getLocalHost();
//		//System.out.println(ia);
//		String mac = GogetLocalMac.getLocalMac(ia);
//		
//		tu.setCarrierId(carrierId);
//		tu.setMac(mac); 
//		tu.setUserId(userId); 
//	 
//		 
//	    String jsonString = JSON.toJSONString(tu); 
//		 
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//	 
//		String url = baseUrl+Tvvas_Constant.UrlVar_Login ;
//		HttpPost httpPost = new HttpPost(url);			
// 
//		//System.out.println("url:"+url);
//		//System.out.println("请求包:"+jsonString);
//
//		httpPost.setEntity(new StringEntity(jsonString, Charset.forName("UTF-8")));		
//
//		CloseableHttpResponse response2 = httpclient.execute(httpPost);
//		
//		try {			
//		    System.out.println(response2.getStatusLine());		    
//		    HttpEntity entity2 = response2.getEntity();
//		    String response2txt=EntityUtils.toString(entity2);		    
//		    System.out.println(response2txt);
//		    /**
//		     * {"sceneType":"0","code":0,"tokenExpiredTime":"20171120161449","serviceUrl":"http://202.99.114.62:35825/PORTAL/dsm",
//		     * "reserved":{"TVYYT":"dc00003060","vasRootCategory":"dc00000727","4kvideoCategory":"dc00003715",
//		     * "searchCategory":"dc00000164","rootFourthCategory":"dc00000523","popRecommend":"dc00000163",
//		     * "secondCategory":"dc00000269","firstCategory":"dc00001051","searchRootCategory":"dc00003087",
//		     * "topCategory":"dc00000164","fourthCategory":"dc00000267"},"systemTime":"2017-11-20 14:14:49","bandwidthThreshold":"2",
//		     * "sceneMap":{"scene003":"夕阳红","scene002":"活力派","scene001":"新生代","scene004":"全家福"},
//		     * "sessionId":"DFFEEE6E20225A34B62FB012748FA356","userToken":"0ECDE0163263321ACD36C69FC87C3230",
//		     * "carrierId":"201","bandwidthStatus":"2","userId":"088111116881"}
//		     * */
//		    //把JSON文本parse成JSONObject
//		    JSONObject joj =  JSON.parseObject(response2txt);
//		    String returnCode =joj.getString("code");
//		    String sessionId = ""; 
//		    
//		    if("0".equals(returnCode)){
//		    	//返回成功
//		    	sessionId = joj.getString("sessionId");
//		    	System.out.println(sessionId);
//		    }else{
//		    	//登录失败
//		    }		    
//
//		} finally {
//		    response2.close();
//		}
//		
//		 
//
//	}
	
//	public static void main(String[] args) throws Exception {
//		Tvvasuser tu = new Tvvasuser();
//		String userId = "088111116881";
//		String carrierId = "201";
//		//获取本机mac地址
//		InetAddress ia = InetAddress.getLocalHost();		
//		String mac = GogetLocalMac.getLocalMac(ia);
//		
//		tu.setCarrierId(carrierId);
//		tu.setMac(mac); 
//		tu.setUserId(userId); 
//		TvvasTools tt = new TvvasTools();
//		String returncode = tt.tvvaslogin(tu);
//		System.out.println(returncode);
//		
// 	 
//		
//	}
	

}
