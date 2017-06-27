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
		//HttpPost post = new HttpPost("http://127.0.0.1:5080/testSpringMVC/uploadTvUserImg");
		HttpPost post = new HttpPost("http://127.0.0.1:5080/uploadTvUserImg");
		
		//用户认证
		String Token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEyMzE3IiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1NDUyMjA5ODgzLCJleHAiOjE0OTYwNTcwMDl9.ek4YYsI89AyNBf8SE9vgezLTg_p7bzHpU5oL6ORafwUDKmlSECbLTMsajb-qU65N4qhmR9o6Bh25LLqApbFvwA";
		Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNTIzIiwiYXVkaWVuY2UiOiJ3ZWIiLCJjcmVhdGVkIjoxNDk1NTQzMzUxMzUzLCJleHAiOjE0OTYxNDgxNTF9.0i-GTtBqDOIwQfrSo4LKrv6lGk970P4P9eV_nDiaOamd64tK0va-jNno1gnIs9AFzpBYcvvnNSVPPXU1dH1lTA";
		Token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1bmFtZTExMSIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5NjE5Njc5MTU4MCwiZXhwIjoxNDk2ODAxNTkxfQ.Byn7kD6SY7EwWEpab8CQnJmnEwnOEFkR6ZNMx3sTjWQb1Q5a5E-uvReHKRQV9NAsGOkZhcQDJj_MCenc0DRB7w";
		post.setHeader("Authorization", Token); 
		
		
		String  imageFileName = "D:\\OOO\\Pictures\\1080.jpg" ;	 
		imageFileName = "D:\\OOO\\Pictures\\BB1883_EN-US15158286681_1920x1080.jpg" ;	
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
