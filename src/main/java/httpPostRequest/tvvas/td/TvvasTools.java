package httpPostRequest.tvvas.td;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import httpPostRequest.tvvas.td.pojo.TvvasProduct;
import httpPostRequest.tvvas.td.pojo.Tvvasuser;

public class TvvasTools {
	
	/**
	 *  1.1  ��¼
	 * 
	 * <TV VAS V100R001C05 TV Store�Ϳͻ��˽ӿڹ淶--�ڲ��ӿ�.docx>
	 * 
	 * json ��ֵ
	 * 	loginByUserId
	 * 
	 *      �����˺ţ�
	 * 		userId 088111116881
	 * 		mac
	 * 		carrierId  201
	 * 
	 * 	http://202.99.114.62:35825/PORTAL/dsm
	 * 
	 *  ---���񻷾� 202.99.114.62:35825
	 * 
	 * */
	
	public String tvvaslogin(Tvvasuser tu ) throws ClientProtocolException, IOException {
		
		    String jsonString = JSON.toJSONString(tu); 
			
			String baseUrl =Tvvas_Constant.BaseUrl;
			String url = baseUrl+Tvvas_Constant.UrlVar_Login ;
			 
			CloseableHttpClient httpclient = HttpClients.createDefault();			
			HttpPost httpPost = new HttpPost(url);			
	 
			//System.out.println("url:"+url);
			//System.out.println("�����:"+jsonString);

			httpPost.setEntity(new StringEntity(jsonString, Charset.forName("UTF-8")));
			CloseableHttpResponse response2 = httpclient.execute(httpPost);
			String response2txt= "";
			try {			
			    //System.out.println(response2.getStatusLine());		    
			    HttpEntity entity2 = response2.getEntity();
			    response2txt=EntityUtils.toString(entity2);		    
			    //System.out.println(response2txt);
			    /**
			     * {"sceneType":"0","code":0,"tokenExpiredTime":"20171120161449","serviceUrl":"http://202.99.114.62:35825/PORTAL/dsm",
			     * "reserved":{"TVYYT":"dc00003060","vasRootCategory":"dc00000727","4kvideoCategory":"dc00003715",
			     * "searchCategory":"dc00000164","rootFourthCategory":"dc00000523","popRecommend":"dc00000163",
			     * "secondCategory":"dc00000269","firstCategory":"dc00001051","searchRootCategory":"dc00003087",
			     * "topCategory":"dc00000164","fourthCategory":"dc00000267"},"systemTime":"2017-11-20 14:14:49","bandwidthThreshold":"2",
			     * "sceneMap":{"scene003":"Ϧ����","scene002":"������","scene001":"������","scene004":"ȫ�Ҹ�"},
			     * "sessionId":"DFFEEE6E20225A34B62FB012748FA356","userToken":"0ECDE0163263321ACD36C69FC87C3230",
			     * "carrierId":"201","bandwidthStatus":"2","userId":"088111116881"}
			     * */
			    //��JSON�ı�parse��JSONObject
//			    JSONObject joj =  JSON.parseObject(response2txt);
//			    String returnCode =joj.getString("code");
//			    String sessionId = ""; 
//			    
//			    if("0".equals(returnCode)){
//			    	//���سɹ�
//			    	sessionId = joj.getString("sessionId");
//			    	System.out.println(sessionId);
//			    }else{
//			    	//��¼ʧ��
//			    }		    

			} finally {
			    response2.close();
			}
		
		
		return response2txt;
	}

	
	/**
	 * �˶��ӿ�
	 * 
	 *  1.14  ��Ʒ����/ȡ������
	 * 
	 * <TV VAS V100R001C05 TV Store�Ϳͻ��˽ӿڹ淶--�ڲ��ӿ�.docx>
	 * 
	 * json ��ֵ
	 * 	orderProduct
	 * 
	 *      
	 * 
	 * 	http://202.99.114.62:35825/PORTAL/dsm
	 * 
	 *  ---���񻷾� 202.99.114.62:35825
	 * 
	 * */
	
	public String tvvasUnOrder(TvvasProduct tuiP, String sessionId ) throws ClientProtocolException, IOException {		

	    String jsonString = JSON.toJSONString(tuiP); 
		String url = Tvvas_Constant.BaseUrl+Tvvas_Constant.UrlVar_Order_UnOrder ;
		 
		CloseableHttpClient httpclient = HttpClients.createDefault();			
		HttpPost httpPost = new HttpPost(url);			
		httpPost.setHeader("Cookie", "JSESSIONID=" + sessionId);
		//System.out.println("url:"+url);
		//System.out.println("�����:"+jsonString);

		httpPost.setEntity(new StringEntity(jsonString, Charset.forName("UTF-8")));
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		
		
		String response2txt= "";
		try {			
		    //System.out.println(response2.getStatusLine());		    
		    HttpEntity entity2 = response2.getEntity();
		    response2txt=EntityUtils.toString(entity2);		    
		    //System.out.println(response2txt);
		} finally {
		    response2.close();
		}	
	
		return response2txt;
		
	}
}
