package httpPostRequest.baidu;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
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


public class Post_baidu_singlePush {
	

	public static void main(String[] args) throws Exception {
		
		 
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost("");
		httpPost = new HttpPost("http://180.149.142.209:8450/v1/push/single");
		
		
		httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
		String parameters = "{\"iptvId\":\"23455432\",\"message\":\"eyJkYXRlIjoyMywiaG91cnMiOjE1fQ==\"}"  ;
		
		byte[] content = parameters.getBytes("UTF-8");
		
		//httpPost.setHeader("Content-Length", Integer.toString(content.length));
		String  accessKeyId = "3e83fc1e55764276848d4f61ad02bf65";
		String  secretAccessKey = "b00a679612bc4d85bae428fa0a30399f";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		Date daytime = new Date(); 
        String s = sdf.format(daytime);		
		
		String  authString = "bce-auth-v1" + "/" + accessKeyId + "/"
	                        + s+"Z" + "/" + "1800";
		String signingKey = Post_baidu_singlePush.sha256Hex(secretAccessKey, authString);
		
		String canonicalRequest = "POST" + "\n" + "/v1/push/single" + "\n" + "" +
		"\n" + "content-length:66"+ "\n" +"content-type:application%2Fjson%3Bcharset%3DUTF-8"+"\n" 
				+"host:180.149.142.209%3A8450";
		/**
		POST
 		/v1/push/single

		content-length:66
		content-type:application%2Fjson%3Bcharset%3DUTF-8
		host:180.149.142.209%3A8450
		 * */

		
		String signature = Post_baidu_singlePush.sha256Hex(signingKey, canonicalRequest);
		
		String headerstr = authString+"//"+signature;
		
		System.out.println("----"+headerstr);
		 
		httpPost.addHeader("Authorization",headerstr);
		
		httpPost.addHeader("User-Agent","bce-sdk-java/0.10.28/Windows_10/10.0/Java_HotSpot(TM)_64-Bit_Server_VM/25.161-b12/1.8.0_161/zh/");

		httpPost.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));		
		
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


	}
	
	
	
	
    private static String sha256Hex(String signingKey, String stringToSign) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec( signingKey.getBytes("UTF8"), "HmacSHA256"));
            return new String(Hex.encodeHex(mac.doFinal(stringToSign.getBytes("UTF8"))));
        } catch (Exception e) {
            System.out.println("Fail to generate the signature" );
             
        }
		return "err";
    }
	

}
