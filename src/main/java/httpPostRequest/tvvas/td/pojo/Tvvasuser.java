package httpPostRequest.tvvas.td.pojo;

/**
 * 用于 Tvvas 的 用户 登录使用 
 * 
 * */
public class Tvvasuser {
	
	String  userId ;
	String  mac;
	String  carrierId  ;
	 
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	 

}
