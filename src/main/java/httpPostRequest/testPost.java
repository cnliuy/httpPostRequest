package httpPostRequest;

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


/**
 * ģ��ͻ�����۲��� ͨ��Post��ʽ
 * */
public class testPost {

	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//-------------------------------------http://localhost:8080/lr/task/create------------------------------		
		HttpPost httpPost = new HttpPost("http://localhost:8080/lr/api/v1/task/create?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3&writesess=23");
		//HttpPost httpPost = new HttpPost("http://localhost:8080/lr/task/create");		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		//nvps.add(new BasicNameValuePair("username", "admin"));
		//nvps.add(new BasicNameValuePair("digest", "f6364126029045522b9a3dc0937ec26106bbe0d3"));
		//nvps.add(new BasicNameValuePair("writesess", "23"));
		nvps.add(new BasicNameValuePair("id", ""));
		nvps.add(new BasicNameValuePair("title", "090909012343"));
		nvps.add(new BasicNameValuePair("description", "111111"));
		nvps.add(new BasicNameValuePair("gender", "����"));
		nvps.add(new BasicNameValuePair("jobType", "��ְ"));
		nvps.add(new BasicNameValuePair("timeRquirement", "111111"));
		nvps.add(new BasicNameValuePair("district", "111111"));
		nvps.add(new BasicNameValuePair("paymentCalcWay", "Сʱ"));
		nvps.add(new BasicNameValuePair("payment", "11111111"));
		nvps.add(new BasicNameValuePair("phoneCall", "Сʱ"));
		nvps.add(new BasicNameValuePair("jobRequirements", "1"));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		try {	    
		    HttpEntity entity2 = response2.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2.getStatusLine());
		    System.out.println(response2txt);
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    //EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}

	}

}
