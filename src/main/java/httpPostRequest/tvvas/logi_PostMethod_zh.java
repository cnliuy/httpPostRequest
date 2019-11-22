package httpPostRequest.tvvas;

public class logi_PostMethod_zh {
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
		String carrierId = "201";
		String accessChannel = "10"; //第三方 cp
		//String area = "12";		
		String area = null;
		String ip = "192.168.18.111";
		String mac = "F44C70FF2326";
		String userId = "cutv201711272010101";//rewrewrere&carrierid=20
		String versionCode = "3180";
		String model = "E900V21D";
		String osVersion = "4.4.2";
		
		
		String loginByUserIdurl;	
		//loginByUserIdurl = "http://211.94.218.245:9080/login";
		loginByUserIdurl = "http://202.99.114.63:35003/PORTAL/dsm/loginByUserId";   //jx
		
		
		//loginByUserIdurl = "http://202.99.114.14:35824/PORTAL/dsm/loginByUserId";   //现网
		//public static final String BaseUrl = "http://202.99.114.14:35824/PORTAL/dsm/";//现网
		//Url = "http://192.168.2.24:35825/PORTAL/dsm/";//内网   //使用lbs
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
		 *  QueryUserJoinedCampaigns  1.93.	查询新营销活动接口
		 * 
		 * */
		String status = "1";  //0	未生效     ; 1	已生效

		int page = 1;
		int pageSize = 100;
		testPost_QueryUserJoinedCampaigns.QueryUserJoinedCampaigns(serviceUrl, sessionId, null , status, page, pageSize);

	}

}
