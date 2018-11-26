package httpPostRequest.tvbss;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Get_t_baidu_Mu {

	public static void main(String[] args) throws ClientProtocolException, IOException {
	 
		for(int i = 0 ; i<1000 ; i++) {
			
			Get_t_baidu_Mu p = new Get_t_baidu_Mu();   //复制后 此处需要修改
			p.testUrl2();
			System.out.println("执行第"+i+"次");
			System.out.println("-----------");
			
		}
	}
	
	public  void testUrl2() throws ClientProtocolException, IOException {
		
		String url = "http://127.0.0.1:6880/getDocMess?id=1";
		//url = "http://localhost:6280/queryPromotionByArea?areacode=022";
		//url = "http://60.29.181.148:6280/queryPromotionByArea?areacode=022";
		url = "http://localhost:6280/hc2";
		url = "http://127.0.0.1:6280/hc2";
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		System.out.println(url);
		HttpGet httpget = new HttpGet(url);
		System.out.println(url);

		CloseableHttpResponse response2 = httpclient.execute(httpget);
		try {

			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			String response2txt = EntityUtils.toString(entity2);
			System.out.println(response2txt);

		} finally {
			response2.close();
		}

	}


}
