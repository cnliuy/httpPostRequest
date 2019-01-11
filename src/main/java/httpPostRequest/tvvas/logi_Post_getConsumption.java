package httpPostRequest.tvvas;

public class logi_Post_getConsumption {
	/**
	 * 组合逻辑调用
	 * @throws Exception 
	 * 
	 * 1. 先登录
	 * 2. 调用其他逻辑
	 * 
	 * */
	public static void main(String[] args) throws Exception {
		/**
		 * 1 登陆  获取sessionid
		 * 
		 * */
		String carrierId = "022";
		//String accessChannel = "10"; //第三方 cp
		String accessChannel = "14"; //电视营业厅
		//String area = "12";		
		String area = null;
		String ip = "192.168.18.111";
		String mac = "F44C70FF2326";
		String userId = "02201457871";//rewrewrere&carrierid=20
		String versionCode = "3180";
		String model = "E900V21D";
		String osVersion = "4.4.2";
		
		
		String loginByUserIdurl;	
		//loginByUserIdurl = "http://211.94.218.245:9080/login";
		loginByUserIdurl = "http://202.99.114.63:35003/PORTAL/dsm/loginByUserId";   //jx 镜像		
		//loginByUserIdurl = "http://202.99.114.14:35824/PORTAL/dsm/loginByUserId";   //现网
		
		System.out.println("Portal 登陆地址:" + loginByUserIdurl );
		
		String[] s = Post_login_vas_muti.vasloginReturnToken(loginByUserIdurl, carrierId, accessChannel, area, ip, mac, userId, versionCode, model, osVersion) ;
		//serviceUrl sessionId userToken
		String serviceUrl = s[0];
		String sessionId = s[1];
		String userToken = s[2];
		
		System.out.println(serviceUrl + "; sessionId="+sessionId+"; userToken="+ userToken);
		
		/**
		 * 2 其他逻辑
		 * 
		 *  1.31.	查询用户历史消费记录
		 *  getConsumption	
		 *   
		 * 
		 * */
		String spId = "";  //增值业务SP 的编号(保留字段，暂时查询全量的消费记录	)
		String month = "201810";   
		String orderMode = "";   //如果该字段为空，则需要返回所有订购模式的消费记录。
		int page = 1;   
		int pageSize = 10;   
		 
 
		testPost_GetConsumption_131.goGetConsumption(serviceUrl, sessionId, spId , month,orderMode, page, pageSize);
		 
		 
		 
	}

}
