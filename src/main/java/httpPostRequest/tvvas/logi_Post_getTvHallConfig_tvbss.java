package httpPostRequest.tvvas;

public class logi_Post_getTvHallConfig_tvbss {
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
		
		carrierId = "211";  //黑龙江
		//carrierId = "201"; //天津
		carrierId = "205";  //北京
		//carrierId = "204";  //河南
		 
		
		String userId = "395294249080236389_204";//rewrewrere&carrierid=20
		
		//  userId = "";
		userId = "088112341551";
		//userId = "371280436582860154_204";
		userId = "371991018832735241";
		userId = "371874421965956216";
		//userId = "2309047395";
		//userId = "395294249080236389";
		
		//userId = "01-01010252606-01";
		
		userId = "01006838635";
		
		//String accessChannel = "10"; //第三方 cp
		String accessChannel = "14"; //电视营业厅
		//String area = "12";		
		String area = null;
		String ip = "192.168.18.111";
		String mac = "F44C70FF2326";		
		
		String versionCode = "3180";
		String model = "E900V21D";
		String osVersion = "4.4.2";
		
		
		String loginByUserIdurl;	
		//loginByUserIdurl = "http://211.94.218.245:9080/login";
		
		//http://202.99.114.26:35827/PORTAL/dsm/getTvHallConfig
		
		
		//loginByUserIdurl = "http://202.99.114.63:35003/PORTAL/dsm/loginByUserId";   //jx 镜像		
		loginByUserIdurl = "http://202.99.114.14:35824/PORTAL/dsm/loginByUserId";   //现网
		
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
		 *  1.96.	获取电视营业厅配置信息接口
		 *  接口功能
		 *  获取电视营业厅配置信息
		 *  方法名称为“getTvHallConfig”
		 *  请求消息体
		 *  无
		 *  
		 *   
		 * 
		 * */

		 
 
		testGet_GetTvHallConfig_1_96.GetTvHallConfig(serviceUrl, sessionId);
		 
		 
		 
	}

}
