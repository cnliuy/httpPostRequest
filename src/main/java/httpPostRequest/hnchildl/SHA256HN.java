package httpPostRequest.hnchildl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

public class SHA256HN {
	public static int  seq = 1;
	
	public static void main(String[] args) {
		String  s = SHA256HN.encrypt("1234");
		System.out.println(s);
		
	}
	
	/**
     * SHA-256算法
     * 
     * @param strSrc 要加密的字符串
     * @return
     */
    public static String encrypt(String strSrc)  {
        if (StringUtils.isEmpty(strSrc))
        {
            return null;
        }
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try
        {
            md = MessageDigest.getInstance("SHA-256");
            md.update(bt);
            strDes = bytes2Hex(md.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            return strDes;
        }
        return strDes;
    }		
	
	/**
     * byte数组与Hex字符串互转
     * 
     * @param bts 数组
     * @return des Hex字符
     */
    public static String bytes2Hex(byte[] bts)    {
    	
        StringBuffer buf = new StringBuffer();
        String tmp = null;
        for (int i = 0; i < bts.length; i++)
        {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1)
            {
                buf.append('0');
            }
            buf.append(tmp);
        }
        return buf.toString();
    }
	

	
}
