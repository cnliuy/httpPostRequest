package httpPostRequest.push;

import java.nio.charset.Charset;
import java.util.ArrayList;
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

public class Post_test_client {
	

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("http://localhost:4080/api/push/pushOrderInfo");
		httpPost.addHeader("Content-Type","application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");  
		//String Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwMzM5NjYzNjIxMywiZXhwIjoxNTA0MDAxNDM2fQ.cO4NK45XLsS7b4EspYa_v2p00Ty87eDU6m0OiEuoUay_EORZBa1jCFskAnnlTCRHvu--hJHznP3WgUYpENC39Q";
		//httpPost.setHeader("Authorization", Token);  
		
		String phoneNumber= "13322227777";
		String pushIOSStatus= "1"; //推送平台是否为IOS 	"1"：是，"0"：不是
		String pushAndroidStatus= "0";
		String pushBaiduStatus= "0";
		String registrationId= "13322227777";//android
		String deviceToken= ""; //ios
		String baiduRegistrationId= "";
		
		
		String parameters = "{\"phoneNumber\":\""+phoneNumber+"\",\"pushIOSStatus\":\""+
					pushIOSStatus+"\",\"pushAndroidStatus\":\""+pushAndroidStatus
					+"\",\"pushBaiduStatus\":\""+pushBaiduStatus+"\",\"registrationId\":\""+
					registrationId+"\",\"deviceToken\":\""+deviceToken+"\",\"baiduRegistrationId\":\""+baiduRegistrationId+"\"" + 
				"}" + 
				"";
	
		String needencodestr =  phoneNumber+"_"+
				pushIOSStatus+"_"+
				pushAndroidStatus+"_"+
				pushBaiduStatus+"_"+
				registrationId+"_"+
				deviceToken+"_"+
				baiduRegistrationId+"_"
				;
		System.out.println("parameters:"+parameters);
		System.out.println("needencodestr:"+needencodestr);
		String tokenkey =EncodeStringUtil.encodeStrByBase64(EncodeStringUtil.encodeStrBySHA256(needencodestr));
		System.out.println("tokenkey:"+tokenkey);
		
		
		System.out.println(parameters);
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		httpPost.setHeader("sign", tokenkey);
		//httpPost.setEntity(new HttpEntity);setRequestEntity(new StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2txt);

		} finally {
		    response2.close();
		}


	}
	

}
