package httpPostRequest.opencuit;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import sun.util.logging.resources.logging;



public class Get_mics31 {

public static void main(String[] args) throws ClientProtocolException, IOException {
	
	
		String areacode= "022";
		String serialnum = "02202402449" ;
		//apk201812 testkeysec
		String clicode = "apk201812" ;
		
		String appkey = "testkeysec";
		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");		
		String timestr = sdf.format(new Date());
		
		int numberlen  = 4;	//从前向后  serialnum
		int timelen =  4;//从后向前  timestr
		
		
		String url = "http://127.0.0.1:6280/mics311?areacode="+areacode+"&serialnum="+serialnum+"&timestr="+timestr+"&clicode="+clicode;
		//url = "http://202.99.114.63:18023/queryPromotionByArea?areacode=010";  //zs
		
		
		String serialnum_c = serialnum.substring(0,numberlen);
		String timestr_c = timestr.substring(timestr.length()-timelen, timestr.length());
		
		System.out.println(serialnum +", 截取"+numberlen+"位 --"+ serialnum_c+"---" );
		System.out.println(timestr +", 截取"+timelen+"位 --"+ timestr_c+"---" );
		
		String pinstr = areacode+serialnum_c+timestr_c;
		String token_md5str  ="";//初始化 后面赋值
		try {
			System.out.println( "拼串:"+pinstr);
			token_md5str = MD52.md5(pinstr, appkey);
			System.out.println( "token:"+token_md5str);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
				
				
				
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		httpget.setHeader("TOKEN",token_md5str);

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
