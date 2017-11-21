package httpPostRequest.tools;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

public class GogetLocalMac {
	
	public static String getLocalMac(InetAddress ia) throws SocketException {
		String localmac = ""; 
		//��ȡ��������ȡ��ַ
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		//System.out.println("mac���鳤�ȣ�"+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//�ֽ�ת��Ϊ����
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			//System.out.println("ÿ8λ:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		localmac = sb.toString().toUpperCase();
		//System.out.println("����MAC��ַ:"+localmac);
		return localmac;
	}

}
