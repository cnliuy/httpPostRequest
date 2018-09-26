package httpPostRequest.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.apache.commons.lang.StringUtils;


public class SendDemo {
	public static void main(String[] args) {
	
		String uid="";
		String pwd="";
		String moblies="13716205360";
		String content="【百度】您验证码是08051608";
		String ext="";
		String attime="";
		String result = SendDemo.smsSend(uid, pwd, moblies, content, ext, attime);
		System.out.println("result="+result);
	}
	
	//发送短信
	public static String smsSend(String userid, String password, String mobile, String content, String ext, String attime) {
		String errMess = "";
		StringBuffer sendData = new StringBuffer("");
		try {
			sendData.append("uid=").append(userid);	// 用户名
			String pwd = getMD5(password);//原始密码做MD5加密，32位大写格式		
			sendData.append("&password=").append(pwd);	// 密码
			
			sendData.append("&encode=").append("GBK");	// encode=GBK或者encode=utf8
			String contentBase64 = Base64.getEncoder().encodeToString(content.getBytes("gbk"));// 先用encode中定义的格式编码，再用base64加密内容
			sendData.append("&encodeType=base64");	// 固定
			sendData.append("&content=").append(contentBase64);	// base64加密后的内容
			
			sendData.append("&mobile=").append(mobile);	// 手机号
//			sendData.append("&cid=").append("45955855252252555");	// 唯一标识，选填，如果不填系统自动生成作为当前批次的唯一标识
			if(!StringUtils.isEmpty(ext)){
				sendData.append("&extNumber=").append(ext);	// 扩展
			}
			
			if(!StringUtils.isEmpty(attime)){
				sendData.append("&schtime=").append(attime);	// 定时时间，选填，格式2008-06-09 12:00:00
			}
			errMess =sendPost("http://ip:8090/jtdsms/smsSend.do", sendData.toString());//普通短信
//			errMess =sendPost("http://ip:8090/jtdsms/sendData.do", sendData.toString());//个性短信
		} catch (Exception e) {
			errMess = "-601";
		}	
		return errMess;
	}
	
	
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	public static String getMD5(String sourceStr){
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}
