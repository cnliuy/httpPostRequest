package httpPostRequest.tvvas.td.pojo;
/**
 * 订购 退订 接口
 * 
 * 	1.14 产品订购/取消续订
 * 
 * */
public class TvvasProduct {
	
	String  productId ; //产品id
	
	String  action ; //操作类型	1：订购；	2：退订
	/**
	 * 1：金额订购 	
	 * 2：IPTV积分订购 	
	 * 3：电信积分订购
	 * 4：赠送金额订购
	 * 6：虚拟游戏币消费
	 * 7：虚拟游戏币充值
	 * 9：卡密支付
	 * */
	String  orderMode ;  //默认  填1  ----金额订购
	
	String continueType; // 0：只订购  1：订购且自动续订  //默认  填0

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getContinueType() {
		return continueType;
	}

	public void setContinueType(String continueType) {
		this.continueType = continueType;
	}





}
