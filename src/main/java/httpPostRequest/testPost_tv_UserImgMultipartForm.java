package httpPostRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class testPost_tv_UserImgMultipartForm {
/**
 * 上传头像测试类
 *		返回结果：   
 *  
 *  	http://127.0.0.1:8080/uploadTvUserImg
 *  
 **/

	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://127.0.0.1:8080/uploadTvUserImg");
		
		
		//用户认证
		String Token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEyMzE3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1MDAwMTIyOTcyLCJleHAiOjE0OTU2MDQ5MjJ9.6MBtTb5w15lVnUs33CJAXPdE5sAMFfGW5GNOO2Tye7VdaPtuTatSp1o7E6o2NSmDFfQD1-cx5OaThyQbeh3hoA";
		post.setHeader("Authorization", Token); 
		
		
		String  imageFileName = "D:\\OOO\\Pictures\\1080.jpg" ;	 
		imageFileName = "D:\\OOO\\Pictures\\1900.jpg" ;	
		File file = new File(imageFileName);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();         
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addBinaryBody("imageFile", file, ContentType.DEFAULT_BINARY, imageFileName);

		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			HttpResponse response = httpclient.execute(post);
			System.out.println(response.getStatusLine());
			
			HttpEntity entity2 = response.getEntity();
		    String response2txt=EntityUtils.toString(entity2);
		    System.out.println(response2txt);
		    
		} catch (ClientProtocolException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.println("ok 上传结束");

	}

}
