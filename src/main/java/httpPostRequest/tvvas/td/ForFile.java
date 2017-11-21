package httpPostRequest.tvvas.td;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ForFile {
	
	 //�����ļ�·��
   private static String path = "D:\\file\\";
   
   //�ļ�·��+����
   private static String filenameTemp;
   /**
    * �����ļ�
    * @param fileName  �ļ�����
    * @param filecontent   �ļ�����
    * @return  �Ƿ񴴽��ɹ����ɹ��򷵻�true
    */
   public static boolean createFile(String fileName,String filecontent){
       Boolean bool = false;
       filenameTemp = path+fileName+".txt";//�ļ�·��+����+�ļ�����
       File file = new File(filenameTemp);
       try {
           //����ļ������ڣ��򴴽��µ��ļ�
           if(!file.exists()){
               file.createNewFile();
               bool = true;
               System.out.println("success create file,the file is "+filenameTemp);
               //�����ļ��ɹ���д�����ݵ��ļ���
               writeFileContent(filenameTemp, filecontent);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return bool;
   }
   
   /**
    * ���ļ���д������
    * @param filepath �ļ�·��������
    * @param newstr  д�������
    * @return
    * @throws IOException
    */
   public static boolean writeFileContent(String filepath,String newstr) throws IOException{
       Boolean bool = false;
       String filein = newstr+"\r\n";//��д����У�����
       String temp  = "";
       
       FileInputStream fis = null;
       InputStreamReader isr = null;
       BufferedReader br = null;
       FileOutputStream fos  = null;
       PrintWriter pw = null;
       try {
           File file = new File(filepath);//�ļ�·��(�����ļ�����)
           //���ļ�����������
           fis = new FileInputStream(file);
           isr = new InputStreamReader(fis);
           br = new BufferedReader(isr);
           StringBuffer buffer = new StringBuffer();
           
           //�ļ�ԭ������
           for(int i=0;(temp =br.readLine())!=null;i++){
               buffer.append(temp);
               // ������֮��ķָ��� �൱�ڡ�\n��
               buffer = buffer.append(System.getProperty("line.separator"));
           }
           buffer.append(filein);
           
           fos = new FileOutputStream(file);
           pw = new PrintWriter(fos);
           pw.write(buffer.toString().toCharArray());
           pw.flush();
           bool = true;
       } catch (Exception e) {
           // TODO: handle exception
           e.printStackTrace();
       }finally {
           //��Ҫ���ǹر�
           if (pw != null) {
               pw.close();
           }
           if (fos != null) {
               fos.close();
           }
           if (br != null) {
               br.close();
           }
           if (isr != null) {
               isr.close();
           }
           if (fis != null) {
               fis.close();
           }
       }
       return bool;
   }
   
   /**
    * ɾ���ļ�
    * @param fileName �ļ�����
    * @return
    */
   public static boolean delFile(String fileName){
       Boolean bool = false;
       filenameTemp = path+fileName+".txt";
       File file  = new File(filenameTemp);
       try {
           if(file.exists()){
               file.delete();
               bool = true;
           }
       } catch (Exception e) {
           // TODO: handle exception
       }
       return bool;
   }
   
   /**
    * �� list ������ ������д���ļ� 
    * 
    * */
   public static boolean writeFileContinu_Chixu( ArrayList<String> strlist ,String path) throws IOException{
   	Boolean bool = false;
   	try {  
           SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");  
           System.err.println(sdf2.format(new Date()));  
        
           // �����ļ���  
           File tf = new File(path);  
           if (!tf.exists()) {  
               tf.mkdir();  
           }  
           
           
           //File f = new File("E:\\��ʱ�ļ�\\outfile"+ sdf2.format(new Date()) + ".txt");  
           File f = new File(path+"\\outfile"+ sdf2.format(new Date()) + ".txt"); 
           if (!f.exists()) {  
               f.createNewFile();  
               System.err.println(f + "�Ѵ�����");  
           }  
            
           byte[] s;  
           RandomAccessFile rf = new RandomAccessFile(f, "rw");  
 
           long count = rf.length();  
 
           rf.seek(count);  
           // ��Ҫ���У��� \r\n ����Ҫ��  
           for(int line = 0; line < strlist.size(); line++){  
           	 String str=strlist.get(line)+"\r\n";
           	 s = str.getBytes();  
                rf.write(s);  
           } 
           rf.close();  
           bool = true;
 
//         for (int i = 0; i < 4; i++) {  
//             str = "���ǵ�   " + i + "���ı�ʾ��\r\n";  
//             s = str.getBytes();  
//             rf.write(s);  
//         }  
           
 
       } catch (Exception e) {  
           e.printStackTrace();  
           System.err.println("��д����");  
 
       }  
   	
   	return bool;
   	
   }
   
   
   
   public static void main(String[] args) {
       UUID uuid = UUID.randomUUID();
       createFile(uuid+"myfile", "�ҵ���˵��ͣ���ȴ�,���ù�â������ʪ��ͫ��,ӳ����������ӵ�еĲʺ�,���ұ�����Ƭ��������,��Ϊ�����ҵ��� �ҵ���");
   }

}
