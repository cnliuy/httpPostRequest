package httpPostRequest;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 全版本的Post 
 * 测试 注册流程
 * */
public class testPost_Reg {

	public static void main(String[] args) throws Exception {
		/**
		 * 注册步骤:
		 * 
		 * 
		 * 1. 检查手机号是否被占用  Get
		 * 	http://url:port/lr/api/v1/usertools/checkPhonenum?phonenum={phonenum}
		 * 	检查手机号是否被占用。
		 * 
		 * 2. 手机获取校验短信 Get
		 * 	http://url:port/lr//api/v1/phoneCollect/genCaptchacodeByPhone?phonenumber={phonenumber}
		 * 	没占用的手机号收校验短信
		 * 
		 * 3. 核实用户和校验短信 Get
		 * 	http://url:port/lr/api/v1/phoneCollect/checkPhonenumber?phonenumber={phonenumber}&captchacode={captchacode}
		 * 
		 * 4. 检查loginName的唯一性
		 * 	http://url:port/lr/api/v1/userregister/checkLoginName?loginName={username}
		 * 	注：	loginname 由客户端以UUID的方式生成，传送到服务端检验唯一性
		 * 		参见UUIDCreate类
		 * 
		 * 		String uuid = UUID.randomUUID().toString(); 
		 * 		String uuids = uuid.substring(0,8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24); 
		 * 
		 * 5. 用户注册 Post （下面程序）
		 * 	http://url:port/lr/api/v1/userregister/
		 * 
		 * */
		
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//-------------------------------------http://localhost:8080/lr/api/v1/userregister------------------------------
		
		//HttpPost httpPost = new HttpPost("http://localhost:8080/lr/task/create?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3&writesess=23");
		//--  HttpPost httpPost = new HttpPost("http://localhost/lr/api/v1/userregister/");
		//--  HttpPost httpPost = new HttpPost("http://123.59.78.43:8080/lr/api/v1/userregister/");
		HttpPost httpPost = new HttpPost("http://localhost/lr/api/v1/userregister/");
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		String uuid = UUID.randomUUID().toString(); 
		String loginName = uuid.substring(0,8)+uuid.substring(9,13)+uuid.substring(14,18)+uuid.substring(19,23)+uuid.substring(24); 
		nvps.add(new BasicNameValuePair("loginName", loginName));
		nvps.add(new BasicNameValuePair("name", "user007"));
		nvps.add(new BasicNameValuePair("password", "111111"));
		nvps.add(new BasicNameValuePair("phonenumber", "13662127862"));
		nvps.add(new BasicNameValuePair("captchacode", "5683"));		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
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
