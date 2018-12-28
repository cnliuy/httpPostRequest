package httpPostRequest.tvvas;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Post_login_vas_muti {
	
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 0 ; i< 1 ; i++) {
			
			Post_login_vas_muti p = new Post_login_vas_muti();
			System.out.println("------------------------"+"开始请求:"+ i);
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String TimeString = time.format(new java.util.Date());
			System.out.println(TimeString);
			p.vaslogin();
			 
			TimeString = time.format(new java.util.Date());
			
						
			
			System.out.println(TimeString);
			System.out.println("------------------------"+"结束请求:"+i);
			try{
				Thread.currentThread().sleep(10000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}

		}
		
		
	}
	/**
	 * 
	 * 1.1.1  用户登陆
	 * 返回
{
	"resultSwitch": "0",
	"userIdForIqy": "F44C70FF2323240z000000000000000000000000000000000000000000000000",
	"notifyInterval": 15,
	"sceneType": "0",
	"code": 0,
	"tokenExpiredTime": "20181228220259",
	"serviceUrl": "http://202.99.114.63:35901/PORTAL/dsm",
	"reserved": {
		"iqiyiCategory": "dc00026117",
		"DUIVideoCategory": "dc00005646",
		"newStoreDSM": "dc00025753",
		"searchrootcategoryforiqiyi": "dc00026120"
	},
	"systemTime": "2018-12-28 20:02:59",
	"doubleAuthSwitch": "0",
	"sceneMap": {
		"1": "新生代",
		"0": "全家福",
		"scene003": "夕阳红",
		"scene002": "活力派",
		"scene001": "新生代",
		"scene004": "全家福"
	},
	"sessionId": "57AEF90AC6FE2D158B186E73754D1A95",
	"userToken": "0EA13E3D676C32C81E6B360F287C3231",
	"carrierId": "240",
	"userId": "F44C70FF2323_240",
	"carrierIqyType": "1"
}
	 * 
	 * */
	public void vaslogin() throws Exception {

		String smscode = "3486";
		String url;
		url = "http://211.94.218.245:9080/login";
		url = "http://202.99.114.63:35003/PORTAL/dsm/loginByUserId";   //zs
		
		/**
		 * http://202.99.114.63:30721/act/monthFree/enter.html?carrierid=201&userId=cutv201711272012321&
		 * resolution=hd&homeUrl=http://www.baidu.com
		 * 
		 * 
		 * */

		String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";
		// "{\"username\":\"120101198705063021_18620007122\",\"phonenum\":\"18620007122\",\"smscode\":\"1221\",\"usertype\":\"1\"}";
		parameters = "{\"username\":\"123456123456123456_15620011620\",\"phonenum\":\"15620011620\",\"smscode\":\""
				+ smscode + "\",\"usertype\":\"1\"}";
		parameters = "{\"accessChannel\":\"9\",\"accessItem\":\"1\",\"area\":\"12\","
				+ "\"carrierId\":\"240\",\"ip\":\"192.168.18.186\",\"mac\":\"F44C70FF2323\","
				+ "\"model\":\"E900V21D\",\"osVersion\":\"4.4.2\",\"userId\":\"F44C70FF2323\",\"versionCode\":\"3180\"}";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");
		// String Token =
		// "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTUwMzM5NjYzNjIxMywiZXhwIjoxNTA0MDAxNDM2fQ.cO4NK45XLsS7b4EspYa_v2p00Ty87eDU6m0OiEuoUay_EORZBa1jCFskAnnlTCRHvu--hJHznP3WgUYpENC39Q";
		// httpPost.setHeader("Authorization", Token);
		
		//-- 打印参数
		// System.out.println(parameters);
		
		
		// parameters =
		// "{\"username\":\"admin1\",\"password\":\"$2a$10$3DYbbsL94OFlV6McoKS8V./E7oT5p9bTeMymmWPeUB3wo7wX0kssC\"}";
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
		// httpPost.setEntity(new HttpEntity);setRequestEntity(new
		// StringEntity("{\"username\":\"admin\",\"password\":\"admin\"}","","UTF-8"));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {
			HttpEntity entity2 = response2.getEntity();

			Header headers[] = response2.getAllHeaders();
			int ii = 0;
			while (ii < headers.length) {
				//System.out.println(headers[ii].getName() + ":" + headers[ii].getValue());
				++ii;
			}
			String response2txt = EntityUtils.toString(entity2);
			System.out.println(response2txt);

		} finally {
			response2.close();
		}

		/**
		 * 
		 * 
		 */
	}
	
	
	/**
	 * 
	 * 静态方法 可被外部调用 
	 *  直接返回 token
	 * 可做后续的逻辑处理
	 * 
	 * */
	public static String vasloginReturnToken() throws Exception {
		String returncode = "";
		
		String carrierId = "240";
		String accessChannel = "9";
		String area = "12";		
		String ip = "192.168.18.186";
		String mac = "F44C70FF2323";
		String userId = "F44C70FF2323";
		String versionCode = "3180";
		String model = "E900V21D";
		String osVersion = "4.4.2";
		
		
		String url;	
		url = "http://211.94.218.245:9080/login";
		url = "http://202.99.114.63:35003/PORTAL/dsm/loginByUserId";   //zs
		
		String userToken = "";
		String serviceUrl = "";
		String sessionId = "";
		

		
		/**
		 * http://202.99.114.63:30721/act/monthFree/enter.html?carrierid=201&userId=cutv201711272012321&
		 * resolution=hd&homeUrl=http://www.baidu.com
		 * 
		 * 
		 * */
		
		String parameters = "{\"username\":\"admin\",\"password\":\"admin\"}";

		parameters = "{\"accessChannel\":\"9\",\"accessItem\":\"1\",\"area\":\"12\","
				+ "\"carrierId\":\"240\",\"ip\":\"192.168.18.186\",\"mac\":\"F44C70FF2323\","
				+ "\"model\":\"E900V21D\",\"osVersion\":\"4.4.2\",\"userId\":\"F44C70FF2323\",\"versionCode\":\"3180\"}";
		parameters = "{\"accessChannel\":\""+accessChannel+"\",\"accessItem\":\"1\",\"area\":\""+area+"\","
				+ "\"carrierId\":\""+carrierId+"\",\"ip\":\""+ip+"\",\"mac\":\""+mac+"\","
				+ "\"model\":\""+model+"\",\"osVersion\":\""+osVersion+"\",\"userId\":\""+userId
				+"\",\"versionCode\":\""+versionCode+"\"}";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
		httpPost.setHeader("Accept", "application/json");
		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {
			HttpEntity entity2 = response2.getEntity();

			Header headers[] = response2.getAllHeaders();
			int ii = 0;
			while (ii < headers.length) {
				//System.out.println(headers[ii].getName() + ":" + headers[ii].getValue());
				++ii;
			}
			String response2txt = EntityUtils.toString(entity2);
			
			JSONObject jsonObject = JSONObject.parseObject(response2txt);
			userToken = jsonObject.getString("userToken");
			serviceUrl = jsonObject.getString("serviceUrl");
			sessionId = jsonObject.getString("sessionId");			 
			returncode = userToken+" "+serviceUrl;			
			//System.out.println(userToken+" "+serviceUrl);

		} finally {
			response2.close();
		}
		
		return returncode;

	}

}
