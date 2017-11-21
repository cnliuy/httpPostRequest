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
	 * 退订 所需参数
	 * 
	 * 	userId
	 *  carrierId
	 *  productId
	 *  
	 * */
	public static void main(String[] args) throws Exception {
		//----------------------
		//	读取 excel
		//    excel的列从第0列开始
		//         第一行不读取,为列表行
		//----------------------
		int[] intArray = {0,1,2};//读取的列号  从第0行开始
		String filepath = "E:\\testUnorder.xlsx";//
		String outtxtpath ="E:\\临时文件2";
		
		//获取本机mac地址
		InetAddress ia = InetAddress.getLocalHost();		
		String mac = GogetLocalMac.getLocalMac(ia);			
		
		ArrayList<String> excelcontent = new ArrayList<String>();		
		ArrayList<String> strlisttotxt = new ArrayList<String>();
		
		 
		
		try {			
			excelcontent  = ExcelTools.readExcelWithOutTitle(filepath, intArray); 			
			for(int i=0; i<excelcontent.size(); i++)    {   
			     String linstr = excelcontent.get(i);  
				 //登录和退订操作
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
		
		 
		//写到txt文件中
		try {
			//String path ="E:\\临时文件2";
			ForFile.writeFileContinu_Chixu(strlisttotxt,outtxtpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	
	
	public   String  UnOrderPackage(String userId ,String carrierId,String productId,String MAC ) throws ClientProtocolException, IOException {
		String returnStr ="";
		/**
		 * ----------------------
		 * 	1 	登录
		 * ----------------------
		 * */
		
		Tvvasuser tu = new Tvvasuser();		
		/**
		 *  cutv20150318***0001——Cutv20150318***0100，其中***为省分3位编号。
		 *  北十省每个省分已经开了100个账号，信息是全的，包括宽带账号信息、地市代码等。
		 *   
		 * */
		//String userId = "088111116881";  
		//userId = "cutv201503182010001";
		//String carrierId = "201";
		//String productId = "123";		
		//获取本机mac地址
		//InetAddress ia = InetAddress.getLocalHost();		
		//String mac = GogetLocalMac.getLocalMac(ia);
		
		tu.setCarrierId(carrierId);
		tu.setMac(MAC); 
		tu.setUserId(userId); 
		TvvasTools tt = new TvvasTools();
		String returncode = tt.tvvaslogin(tu);
		System.out.println("in testTuiDing.class--"+returncode);
		
		// 判断登录是否成功
	    JSONObject joj =  JSON.parseObject(returncode);
	    String returnCode =joj.getString("code");
	    String sessionId = ""; 	    
	    if("0".equals(returnCode)){
	    	//返回成功
	    	sessionId = joj.getString("sessionId");
	    	//System.out.println(sessionId);
	    	
			/**
			 * ----------------------
			 * 	2 	退订
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
		    	//退订OK
		    	
		    }else{
		    	//退订失败
		    	System.out.println("userId:"+userId+"--carrierId:"+carrierId+"---productId:"+productId+"----退订失败");
		    	returnStr = "userId:"+userId+"--carrierId:"+carrierId+"---productId:"+productId+"----退订失败";
			    
		    }
			
	    	
	    }else{
	    	//登录失败
	    	System.out.println(userId+"--"+carrierId+"---登录失败");
	    	returnStr = userId+"--"+carrierId+"---登录失败";
	    
	    }
	    
	    return returnStr;
		 
	}
	
	

}
