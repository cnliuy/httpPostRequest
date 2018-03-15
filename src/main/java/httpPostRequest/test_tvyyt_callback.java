package httpPostRequest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class test_tvyyt_callback {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost("http://60.29.181.148:6088/callbackUrl");
		 httpPost = new HttpPost("http://127.0.0.1:6088/callbackUrl");
		 //httpPost = new HttpPost("https://t2.unicompayment.com/NpfMobilePayfeeWeb/acs.do");
		// httpPost = new HttpPost("http://127.0.0.1:6088/acsoooo");
		// httpPost = new HttpPost("http://60.29.181.148:6088/acs.do");
		// httpPost = new HttpPost("http://127.0.0.1:6088/acs.do");	
		// httpPost = new HttpPost("http://60.29.181.148:6088/acs.do");	
		 
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		//{sign=40wCfRXraqmemreFM0wsnWZato0LyMnOBD65NsHeS1Q=, result=2F9997, area=022, phoneType=03, responseType=02,
		//money=1, number=02201457871, resultDesc=交费金额必须大于等于888.67元, reqNo=1340006}

		nvps.add(new BasicNameValuePair("sign", "40wCfRXraqmemreFM0wsnWZato0LyMnOBD65NsHeS1Q="));
		nvps.add(new BasicNameValuePair("result", "2F9997")); //错误测试时 不需要修改这个值  在服务的配置文件中 改就可以了
		nvps.add(new BasicNameValuePair("area", "022"));
		//nvps.add(new BasicNameValuePair("orderNo", "10023050107180123183948999666"));
		nvps.add(new BasicNameValuePair("phoneType", "03"));
		nvps.add(new BasicNameValuePair("responseType", "02"));
		nvps.add(new BasicNameValuePair("money", "1"));
		nvps.add(new BasicNameValuePair("number", "02201457871"));
		nvps.add(new BasicNameValuePair("resultDesc", "交费金额必须大于等于888.67元"));
		/**
		 *  错误测试时 仅仅需要修改 这个单号值
		 * */
		nvps.add(new BasicNameValuePair("reqNo", "1340006")); //--- 错误测试时 仅仅需要修改 这个单号值 ----------------
		//nvps.add(new BasicNameValuePair("extend", ""));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps ,"UTF-8"));
		//httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2.getStatusLine());
		    System.out.println(response2txt);
		} finally {
		    response2.close();
		}


	}

}
