package httpPostRequest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;


/**
 * ��������:����һ���ಥ�� �������ݵķ��������
 * 
 * */
public class Broadcast {
	
	
	 //���岥�ε�ַ,���ն˿�,���Ͷ˿�  
	 public static final String BroadcastGroup = "228.6.7.8";  
	 public static final int BroadcastRecvPort = 4567;  
	 public static final int BroadcastSendPort = 4566;  
	   
	 //�����ַ���  
	 private String Message;  
	 //���հ��ͷ��Ͱ�  
	 private DatagramPacket DataSendPacket;  
	 private DatagramPacket DataRecvPacket;  
	 //private DatagramSocket SendSocket;  
	 //���ջ������ͷ��ͻ�����  
	 private byte[] SendBuf = new byte[1024];   
	 private byte[] RecvBuf = new byte[1024];  
	 //����Socket  
	 private DatagramSocket SendSocket;  
	 //�ಥ��  
	 MulticastSocket BroadcastClass;  
	 //���캯��  
	 public Broadcast() {  
	  try  
	  {  
	      //����Socket��ʼ��  
	      SendSocket = new DatagramSocket();  
	      //�ಥ�γ�ʼ��  
	      BroadcastClass = new MulticastSocket(BroadcastRecvPort);  
	      //ȷ���౨����ַ  
	      BroadcastClass.joinGroup(InetAddress.getByName(BroadcastGroup));  
	  }  
	  catch(IOException e)  
	  {  
	   e.printStackTrace();  
	  }  
	 }  
	   
	 //��������  
	 public void SendData(String InMsg)  
	 {  
	  try  
	  {  
	      //�������ݰ���ʼ��  
	      SendBuf = InMsg.getBytes();  
	      int length = InMsg.getBytes().length;  
	      DataSendPacket = new DatagramPacket(SendBuf,length,InetAddress.getByName(BroadcastGroup),BroadcastRecvPort);  
	        //���ݷ���  
	         SendSocket.send(DataSendPacket);  
	       }  
	       catch(IOException ioe)  
	       {  
	        ioe.printStackTrace();  
	       }  
	 }  
	   
	 //�������ݲ�����  
	 public String GetData()  
	 {  
	  try  
	  {  
	      //�������ݲ�������ջ�����  
	      DataRecvPacket = new DatagramPacket(RecvBuf,1024);   
	      BroadcastClass.receive(DataRecvPacket);  
	      //ȡ�����ݲ���������  
	      Message = new String(DataRecvPacket.getData(),0,DataRecvPacket.getLength());  
	      Message = Message + " from " + DataRecvPacket.getAddress().getHostName();  
	      Message = Message + " �˿� " + DataRecvPacket.getPort();  
	     }  
	     catch (IOException ioe)  
	     {  
	      ioe.printStackTrace();  
	     }  
	     return Message;  
	 }  

}
