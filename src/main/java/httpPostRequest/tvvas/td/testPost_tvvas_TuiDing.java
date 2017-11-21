package httpPostRequest.tvvas.td;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


import httpPostRequest.tools.GogetLocalMac;
import httpPostRequest.tvvas.td.pojo.TvvasProduct;
import httpPostRequest.tvvas.td.pojo.Tvvasuser;

public class testPost_tvvas_TuiDing {
	/**
	 * �˶� �������
	 * 
	 * 	userId
	 *  carrierId
	 *  productId
	 *  
	 * */
	public static void main(String[] args) throws Exception {
		//----------------------
		//	��ȡ excel
		//    excel���дӵ�0�п�ʼ
		//         ��һ�в���ȡ,Ϊ�б���
		//----------------------
		int[] intArray = {0,1,2};//��ȡ���к�  �ӵ�0�п�ʼ
		String filepath = "E:\\testUnorder.xlsx";//
		String outtxtpath ="E:\\��ʱ�ļ�2";
		
		//��ȡ����mac��ַ
		InetAddress ia = InetAddress.getLocalHost();		
		String mac = GogetLocalMac.getLocalMac(ia);			
		
		ArrayList<String> excelcontent = new ArrayList<String>();		
		ArrayList<String> strlisttotxt = new ArrayList<String>();
		
		 
		
		try {			
			excelcontent  = ExcelTools.readExcelWithOutTitle(filepath, intArray); 			
			for(int i=0; i<excelcontent.size(); i++)    {   
			     String linstr = excelcontent.get(i);  
				 //��¼���˶�����
			     String s[] = linstr.split(";"); 	
			     String userId = s[0];
			     String carrierId = s[1];
			     String productId = s[2];
			     System.out.println(userId+","+carrierId+","+productId);
			     testPost_tvvas_TuiDing td = new testPost_tvvas_TuiDing();
				 String strtotxt = td.UnOrderPackage(userId,carrierId,productId,mac);
				 
				 if("".equals(strtotxt)){
					 
				 }else{
					 strlisttotxt.add(strtotxt);
				 }
			} 			
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		
		 
		//д��txt�ļ���
		try {
			//String path ="E:\\��ʱ�ļ�2";
			ForFile.writeFileContinu_Chixu(strlisttotxt,outtxtpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	
	
	public   String  UnOrderPackage(String userId ,String carrierId,String productId,String MAC ) throws ClientProtocolException, IOException {
		String returnStr ="";
		/**
		 * ----------------------
		 * 	1 	��¼
		 * ----------------------
		 * */
		
		Tvvasuser tu = new Tvvasuser();		
		/**
		 *  cutv20150318***0001����Cutv20150318***0100������***Ϊʡ��3λ��š�
		 *  ��ʮʡÿ��ʡ���Ѿ�����100���˺ţ���Ϣ��ȫ�ģ���������˺���Ϣ�����д���ȡ�
		 *   
		 * */
		//String userId = "088111116881";  
		//userId = "cutv201503182010001";
		//String carrierId = "201";
		//String productId = "123";		
		//��ȡ����mac��ַ
		//InetAddress ia = InetAddress.getLocalHost();		
		//String mac = GogetLocalMac.getLocalMac(ia);
		
		tu.setCarrierId(carrierId);
		tu.setMac(MAC); 
		tu.setUserId(userId); 
		TvvasTools tt = new TvvasTools();
		String returncode = tt.tvvaslogin(tu);
		System.out.println("in testTuiDing.class--"+returncode);
		
		// �жϵ�¼�Ƿ�ɹ�
	    JSONObject joj =  JSON.parseObject(returncode);
	    String returnCode =joj.getString("code");
	    String sessionId = ""; 	    
	    if("0".equals(returnCode)){
	    	//���سɹ�
	    	sessionId = joj.getString("sessionId");
	    	//System.out.println(sessionId);
	    	
			/**
			 * ----------------------
			 * 	2 	�˶�
			 * ----------------------
			 * */		
		    TvvasProduct tuip = new TvvasProduct();
		    //String productId = "";	
		    tuip.setContinueType(Tvvas_Constant.continueType_unorder);
		    tuip.setAction(Tvvas_Constant.action_unorder);
		    tuip.setOrderMode(Tvvas_Constant.orderMode_unorder_jine);
		    tuip.setProductId(productId);
			String returncode2 = tt.tvvasUnOrder(tuip,sessionId);
			JSONObject joj2 =  JSON.parseObject(returncode2);
			System.out.println("in testTuiDing.class--2--"+returncode2);
			String tuidingreturnCode =joj2.getString("code");
		    if("0".equals(tuidingreturnCode)){
		    	//�˶�OK
		    	
		    }else{
		    	//�˶�ʧ��
		    	System.out.println("userId:"+userId+"--carrierId:"+carrierId+"---productId:"+productId+"----�˶�ʧ��");
		    	returnStr = "userId:"+userId+"--carrierId:"+carrierId+"---productId:"+productId+"----�˶�ʧ��";
			    
		    }
			
	    	
	    }else{
	    	//��¼ʧ��
	    	System.out.println(userId+"--"+carrierId+"---��¼ʧ��");
	    	returnStr = userId+"--"+carrierId+"---��¼ʧ��";
	    
	    }
	    
	    return returnStr;
		 
	}
	
	

}
