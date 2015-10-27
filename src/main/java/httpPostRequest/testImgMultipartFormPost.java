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

public class testImgMultipartFormPost {
/**
 * 上传头像测试类
 *  url ：
 *   	/api/v1/usertools/uploaduserpic?username={username}&digest={加密后的passwd}
 * 上传示例：	
 * 	http://localhost:8080/lr/api/v1/usertools/uploaduserpic?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3	 
 *  http://123.59.78.43:8080/lr/api/v1/usertools/uploaduserpic?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3	 
 * 
 * 上传后图片的访问url是：
 * 
 *  	上传后的图片访问url:
 *  	url="http://123.59.78.43:8080/upload/";
 *  	图片名获取处是：
 *  
 *  		http://123.59.78.43:8080/lr/api/v1/usertools/gogetuserimgurl?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3
 *  		http://localhost:8080/lr/api/v1/usertools/gogetuserimgurl?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3
 *		返回结果：   
 *		{
 *		  "retCode" : 1,
 *		  "retInfo" : "http://123.59.78.43:8080/upload/2_20151026143055.jpg"
 *		}
 *  
 *  	http://123.59.78.43:8080/upload/1_20151026151952.jpg 即为图片url。
 *  
 **/

	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://123.59.78.43:8080/lr/api/v1/usertools/uploaduserpic?username=admin&digest=f6364126029045522b9a3dc0937ec26106bbe0d3");
		String  imageFileName = "D:\\个人资源\\Pictures\\72ae04f1gw1ewa5l4kf0tj20xc1e047v.jpg" ;	 
		File file = new File(imageFileName);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();         
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		builder.addBinaryBody("imageFile", file, ContentType.DEFAULT_BINARY, imageFileName);

		HttpEntity entity = builder.build();
		post.setEntity(entity);
		try {
			HttpResponse response = httpclient.execute(post);
			System.out.println(response.getStatusLine());
		} catch (ClientProtocolException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.println("ok 上传结束");

	}

}
