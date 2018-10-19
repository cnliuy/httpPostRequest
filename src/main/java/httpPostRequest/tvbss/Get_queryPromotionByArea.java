/**
 * 
 */
package httpPostRequest.tvbss;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * 通过地区 查活动
 * @author ly
 *
 */
public class Get_queryPromotionByArea {
	
public static void main(String[] args) throws ClientProtocolException, IOException {
		
		String url = "http://127.0.0.1:6880/getDocMess?id=1";
		url = "http://localhost:6280/queryPromotionByArea?areacode=022";
		url = "http://60.29.181.148:6280/queryPromotionByArea?areacode=022";

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);

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
