package httpPostRequest.tvvas.td;

public class Tvvas_Constant {
	/**
	 * 常量类
	 * */
	
	// ---镜像环境 202.99.114.62:35825
	public static final String BaseUrl = "http://202.99.114.62:35825/PORTAL/dsm/";
	
	
	public static final String  UrlVar_Login = "/loginByUserId";
	
	
	public static final String  UrlVar_Order_UnOrder = "/orderProduct";
	
	//退订
	public static final String  action_order = "1"; //订购	
	public static final String  action_unorder = "2";//退订
	public static final String  orderMode_unorder_jine = "1";//订购模式 :1.金额订购
	public static final String  continueType_unorder = "0";//0：只订购 
	

}
