package httpPostRequest;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;



/**
 * 上传多个日志文件
 * 
 * */
public class testPost_UploadLogs {
	public static void main(String[] args) throws Exception {
		String url = "http://127.0.0.1:5080/uploadfile";
		url = "http://60.29.181.148:5080/uploadfile";
		String fileNames = "e:\\upload1.txt;e:\\upload2.txt;e:\\123.rar";
		testPost_UploadLogs.sendFilesPost(url, fileNames);
	}
	
	public static String sendFilesPost(String url, String fileNames) throws UnsupportedEncodingException {
		   HttpClient httpClient = null;
		   HttpPost httpPost;
		   String result = null;		   
		   try {
		      httpClient = new DefaultHttpClient();
		      httpPost = new HttpPost(url);
		      
		      
		      String[] filenames=fileNames.split(";");
		      MultipartEntity reqEntity = new MultipartEntity();
		      for(int i=0;i<filenames.length;i++) {
		               String fileName=filenames[i];
		               FileBody file = new FileBody(new File(fileName));		               
		               reqEntity.addPart("logFile", file); //logFile 为请求后台的File upload;属性		    		    
		               //reqEntity.addPart("file"+i, file);// file1
		      }
		      
			  StringBody phonenumber = new StringBody("aba5");  //中文有问题 ，乱码
			  StringBody uploadOperatingSystem = new StringBody("ios");  
			  StringBody uploadChannel = new StringBody("tttt");   
			  StringBody province = new StringBody("1");   			  
		      reqEntity.addPart("phonenumber", phonenumber); //phonenumber为请求后台的普通参数;属性     	  
		      reqEntity.addPart("uploadOperatingSystem", uploadOperatingSystem); 
		      reqEntity.addPart("uploadChannel", uploadChannel); 
		      reqEntity.addPart("province", province); 
		      
		      httpPost.setEntity(reqEntity);		      
		      HttpResponse response = httpClient.execute(httpPost);
		      if (null != response && response.getStatusLine().getStatusCode() == 200) {
		         HttpEntity resEntity = response.getEntity();
		         if (null != resEntity) {
		            result = EntityUtils.toString(resEntity, HTTP.UTF_8);
		            System.out.println(result);
		         }
		      }
		   } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		   } catch (ClientProtocolException e) {
		      e.printStackTrace();
		   } catch (IOException e) {
		      e.printStackTrace();
		   } catch (Exception e) {
		      e.printStackTrace();
		   } finally {
		      // 关闭连接，释放资源
		      httpClient.getConnectionManager().shutdown();
		   }
		   return result;
	}

}
