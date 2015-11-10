package httpPostRequest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class testPost_CommentAndImgMultipartFormPost {
/**
 * �ϴ����۲�����
 *  url ��
 *   	/lr/rest/comment/create?username={username}&digest={���ܺ��passwd}
 * �ϴ�ʾ����	
 * 	http://123.59.78.43:8080/lr/rest/comment/create?username=enuser123&digest=e60e633cd564e24bcc4bcf91b1c3d7ccb9966d9a
 *  	 
 * http://127.0.0.1:8080/lr/rest/comment/create/?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3
 * �ϴ���ͼƬ�ķ���url�ǣ�
 * 	���ؽ����   
 *		{
 *		  "retCode" : 1,
 *		  "retInfo" : "http://123.59.78.43:8080/upload/30_comment_181_20151109163150.jpg"
 *		}
 *  
 *  	
 *  
 **/

	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://123.59.78.43:8080/lr/rest/comment/create?username=enuser123&digest=e60e633cd564e24bcc4bcf91b1c3d7ccb9966d9a";             
		//url="http://127.0.0.1:8080/lr/rest/comment/create/?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3";
		HttpPost post = new HttpPost(url);
		String  imageFileName = "D:\\������Դ\\Pictures\\72ae04f1gw1ewa5l4kf0tj20xc1e047v.jpg" ;	 
		File file = new File(imageFileName);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();         
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addTextBody("apply_id", "181");
		builder.addTextBody("comments", "lolol����fqwrqwerqwrqerwrqwr");
		builder.addTextBody("starLevel", "3");		
		builder.addBinaryBody("imageFile1", file, ContentType.DEFAULT_BINARY, imageFileName);

		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			HttpResponse response = httpclient.execute(post);
			System.out.println(response.getStatusLine());
			System.out.println(response.getAllHeaders());
		} catch (ClientProtocolException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.println("ok �ϴ�����");

	}

}
