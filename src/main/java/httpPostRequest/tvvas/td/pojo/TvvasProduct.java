package httpPostRequest.tvvas.td.pojo;
/**
 * ���� �˶� �ӿ�
 * 
 * 	1.14 ��Ʒ����/ȡ������
 * 
 * */
public class TvvasProduct {
	
	String  productId ; //��Ʒid
	
	String  action ; //��������	1��������	2���˶�
	/**
	 * 1������ 	
	 * 2��IPTV���ֶ��� 	
	 * 3�����Ż��ֶ���
	 * 4�����ͽ���
	 * 6��������Ϸ������
	 * 7��������Ϸ�ҳ�ֵ
	 * 9������֧��
	 * */
	String  orderMode ;  //Ĭ��  ��1  ----����
	
	String continueType; // 0��ֻ����  1���������Զ�����  //Ĭ��  ��0

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
