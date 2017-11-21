package httpPostRequest.tvvas.td;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xml.sax.SAXException;

public class ExcelTools {
	
	/** 
	 * �ο� http://blog.csdn.net/augus6/article/details/51463478
	 *  java��дexcel��POI��֧��xls��xlsx���ָ�ʽ��
	 * 
	 * 
	 * �����ڵ�һ���Ǳ����е�excel������ 
	 * ����   ����  �Ա�  ��� 
	 * ����   25  ��   175 
	 * ����   22  Ů   160 
	 * ÿһ�й���һ��map��keyֵ���б��⣬value����ֵ��û��ֵ�ĵ�Ԫ����valueֵΪnull 
	 * ���ؽ��������list��Ӧһ��excel�ļ����ڶ����list��Ӧһ��sheetҳ���������map��Ӧsheetҳ�е�һ�� 
	 * @throws Exception  
	 */  
	public static List<List<Map<String, String>>> readExcelWithTitle(String filepath) throws Exception{  
	    String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());  
	    InputStream is = null;  
	    Workbook wb = null;  
	    try {  
	        is = new FileInputStream(filepath);  
	          
	        if (fileType.equals("xls")) {  
	            wb = new HSSFWorkbook(is);  
	        } else if (fileType.equals("xlsx")) {  
	            wb = new XSSFWorkbook(is);  
	        } else {  
	            throw new Exception("��ȡ�Ĳ���excel�ļ�");  
	        }  
	          
	        List<List<Map<String, String>>> result = new ArrayList<List<Map<String,String>>>();//��Ӧexcel�ļ�  
	          
	        int sheetSize = wb.getNumberOfSheets();  
	        for (int i = 0; i < sheetSize; i++) {//����sheetҳ  
	            Sheet sheet = wb.getSheetAt(i);  
	            List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//��Ӧsheetҳ  
	              
	            List<String> titles = new ArrayList<String>();//�������еı���  
	              
	            int rowSize = sheet.getLastRowNum() + 1;  
	            for (int j = 0; j < rowSize; j++) {//������  
	                Row row = sheet.getRow(j);  
	                if (row == null) {//�Թ�����  
	                    continue;  
	                }  
	                int cellSize = row.getLastCellNum();//�����ж��ٸ���Ԫ��Ҳ�����ж�����  
	                if (j == 0) {//��һ���Ǳ�����  
	                    for (int k = 0; k < cellSize; k++) {  
	                        Cell cell = row.getCell(k);  
	                        titles.add(cell.toString());  
	                    }  
	                } else {//��������������  
	                    Map<String, String> rowMap = new HashMap<String, String>();//��Ӧһ��������  
	                    for (int k = 0; k < titles.size(); k++) {  
	                        Cell cell = row.getCell(k);  
	                        String key = titles.get(k);  
	                        String value = null;  
	                        if (cell != null) {  
	                            value = cell.toString();  
	                            System.out.print(value+",");
	                        }  
	                        rowMap.put(key, value);  
	                    }  
	                    sheetList.add(rowMap);  
	                }  
	            }  
	            System.out.println();
	            result.add(sheetList);  
	        }  
	          
	        return result;  
	    } catch (FileNotFoundException e) {  
	        throw e;  
	    } finally {  
	        if (wb != null) {  
	            wb.close();  
	        }  
	        if (is != null) {  
	            is.close();  
	        }  
	    }  
	}  
	
	
	
	/** 
	 * ����4  new
	 * 
	 * intArray �е����飬��0�п�ʼ����,��ѡ�е���,�紫�� {2.3} Ϊ excel�� ��3�͵�4�е�����
	 * 
	 * be using ʵ��ʹ�õ�
	 * @throws Exception  
	 */  
	public static ArrayList<String> readExcelWithOutTitle(String filepath , int[] intArray) throws Exception{  
		ArrayList<String> list = new ArrayList<String>();
	    String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());  
	    InputStream is = null;  
	    Workbook wb = null;  
	    try {  
	        is = new FileInputStream(filepath);  
	          
	        if (fileType.equals("xls")) {  
	            wb = new HSSFWorkbook(is);  
	        } else if (fileType.equals("xlsx")) {  
	            wb = new XSSFWorkbook(is);  
	        } else {  
	            throw new Exception("��ȡ�Ĳ���excel�ļ�");  
	        }          
	        
	          
	        int sheetSize = wb.getNumberOfSheets();         
	        Sheet sheet = wb.getSheetAt(0);  
	        List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//��Ӧsheetҳ  
	              
	        List<String> titles = new ArrayList<String>();//�������еı���  
	              
	        int rowSize = sheet.getLastRowNum() + 1;  
	        System.out.println("��������"+rowSize);
	        for (int j = 0; j < rowSize; j++) {//������  
	            Row row = sheet.getRow(j);  
	            if (row == null) {//�Թ�����  
	                   continue;  
	            }  
                int cellSize = row.getLastCellNum();//�����ж��ٸ���Ԫ��Ҳ�����ж�����  
                if (j == 0) {//��һ���Ǳ�����  
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        titles.add(cell.toString());  
                    }  
                }else{//��������������  
                	
                    Map<String, String> rowMap = new HashMap<String, String>();//��Ӧһ��������  
                    String  linestr ="";
                    //for (int k = 0; k < titles.size(); k++) {  
                    //k���� 
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        //String key = titles.get(k);  
                        String value = null;  
                        if (cell != null) {  
                            value = cell.toString();  
                            /**
                             * ����תΪ �ı���ʽ�󣬱��� ��ѧ����(�� 2.423000E7��)�Ķ�ȡ��ʽ��
                             * ���Զ�ȡ��ʵ�ʵ����� ���� 24000203 
                             * Ŀǰ��������򵥵ķ�����
                             * HSSFCell cell = row.getCell(0);
                             * if(cell.getCellType == HSSFCell.CELL_TYPE_NUMERIC){
                             *     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                             *     String cellValue = cell.toString();
                             * }
                             * */
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            value = cell.getStringCellValue();
                            
                            for(int intA = 0; intA < intArray.length; intA++){  
                            	if(intArray[intA] == k){                       		
                            		
                            		//value = "abc#123";
                            		int i = value.indexOf("@");
                            		if(i>0){
                            			//���ַ���
                            			String a[] = value.split("@"); 	
                            			value= a[0];
                            			//System.out.println(a[0]);
                            			//System.out.println(a[1]);
                            		}else{
                            			//-1
                            			//System.out.println("û��@����ַ���");
                            		}  
                            		
                            		//linestr =linestr+"\'"+value+"\',";
                            		linestr =linestr+value+";";
                            	}
                            }                        
                            
                            //System.out.print(value+",");
                        }  
                        //rowMap.put(key, value);  
                    }  
                    //sheetList.add(rowMap);  
                    //System.out.println(linestr);
                    String strline = linestr;
                    list.add(strline);
                }  
            }         
	    
	    } catch (FileNotFoundException e) {  
	        throw e;  
	    } finally {  
	        if (wb != null) {  
	            wb.close();  
	        }  
	        if (is != null) {  
	            is.close();  
	        }  
	    } 
	    
	    return list;
	}  
	
	
	/** 
	 * old 
	 * 
	 * ���� 
	 * 
	 * be using ʵ��ʹ�õ�
	 * @throws Exception  
	 */  
	public static void readExcelWithTitle2(String filepath) throws Exception{  
	    String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());  
	    InputStream is = null;  
	    Workbook wb = null;  
	    try {  
	        is = new FileInputStream(filepath);  
	          
	        if (fileType.equals("xls")) {  
	            wb = new HSSFWorkbook(is);  
	        } else if (fileType.equals("xlsx")) {  
	            wb = new XSSFWorkbook(is);  
	        } else {  
	            throw new Exception("��ȡ�Ĳ���excel�ļ�");  
	        }  
	          
	        
	          
	        int sheetSize = wb.getNumberOfSheets();         
	        Sheet sheet = wb.getSheetAt(0);  
	        List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//��Ӧsheetҳ  
	              
	        List<String> titles = new ArrayList<String>();//�������еı���  
	              
	        int rowSize = sheet.getLastRowNum() + 1;  
	        System.out.println("��������"+rowSize);
	        for (int j = 0; j < rowSize; j++) {//������  
	            Row row = sheet.getRow(j);  
	            if (row == null) {//�Թ�����  
	                   continue;  
	            }  
                int cellSize = row.getLastCellNum();//�����ж��ٸ���Ԫ��Ҳ�����ж�����  
                if (j == 0) {//��һ���Ǳ�����  
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        titles.add(cell.toString());  
                    }  
                } else {//��������������  
                    Map<String, String> rowMap = new HashMap<String, String>();//��Ӧһ��������  
                    String  linestr ="";
                    //for (int k = 0; k < titles.size(); k++) {  
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        //String key = titles.get(k);  
                        String value = null;  
                        if (cell != null) {  
                            value = cell.toString();  
                            /**
                             * ����תΪ �ı���ʽ�󣬱��� ��ѧ����(�� 2.423000E7��)�Ķ�ȡ��ʽ��
                             * ���Զ�ȡ��ʵ�ʵ����� ���� 24000203 
                             * Ŀǰ��������򵥵ķ�����
                             * HSSFCell cell = row.getCell(0);
                             * if(cell.getCellType == HSSFCell.CELL_TYPE_NUMERIC){
                             *     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                             *     String cellValue = cell.toString();
                             * }
                             * */
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            value = cell.getStringCellValue();
                            linestr =linestr+value+",";
                            //System.out.print(value+",");
                        }  
                        //rowMap.put(key, value);  
                    }  
                    //sheetList.add(rowMap);  
                    System.out.println(linestr);
                }  
            }  
            
           
       

        
	    
	    } catch (FileNotFoundException e) {  
	        throw e;  
	    } finally {  
	        if (wb != null) {  
	            wb.close();  
	        }  
	        if (is != null) {  
	            is.close();  
	        }  
	    }  
	}  
	
	
	/** 
	 * ����3 old
	 * 
	 * intArray �е����飬��0�п�ʼ����,��ѡ�е���,�紫�� {2.3} Ϊ excel�� ��3�͵�4�е�����
	 * 
	 * be using ʵ��ʹ�õ�
	 * @throws Exception  
	 */  
	public static ArrayList<String> readExcelWithTitle_nomal(String filepath , int[] intArray) throws Exception{  
		ArrayList<String> list = new ArrayList<String>();
	    String fileType = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length());  
	    InputStream is = null;  
	    Workbook wb = null;  
	    try {  
	        is = new FileInputStream(filepath);  
	          
	        if (fileType.equals("xls")) {  
	            wb = new HSSFWorkbook(is);  
	        } else if (fileType.equals("xlsx")) {  
	            wb = new XSSFWorkbook(is);  
	        } else {  
	            throw new Exception("��ȡ�Ĳ���excel�ļ�");  
	        }          
	        
	          
	        int sheetSize = wb.getNumberOfSheets();         
	        Sheet sheet = wb.getSheetAt(0);  
	        List<Map<String, String>> sheetList = new ArrayList<Map<String, String>>();//��Ӧsheetҳ  
	              
	        List<String> titles = new ArrayList<String>();//�������еı���  
	              
	        int rowSize = sheet.getLastRowNum() + 1;  
	        System.out.println("��������"+rowSize);
	        for (int j = 0; j < rowSize; j++) {//������  
	            Row row = sheet.getRow(j);  
	            if (row == null) {//�Թ�����  
	                   continue;  
	            }  
                int cellSize = row.getLastCellNum();//�����ж��ٸ���Ԫ��Ҳ�����ж�����  
                if (j == 0) {//��һ���Ǳ�����  
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        titles.add(cell.toString());  
                    }  
                }else{//��������������  
                	
                    Map<String, String> rowMap = new HashMap<String, String>();//��Ӧһ��������  
                    String  linestr ="";
                    //for (int k = 0; k < titles.size(); k++) {  
                    //k���� 
                    for (int k = 0; k < cellSize; k++) {  
                        Cell cell = row.getCell(k);  
                        //String key = titles.get(k);  
                        String value = null;  
                        if (cell != null) {  
                            value = cell.toString();  
                            /**
                             * ����תΪ �ı���ʽ�󣬱��� ��ѧ����(�� 2.423000E7��)�Ķ�ȡ��ʽ��
                             * ���Զ�ȡ��ʵ�ʵ����� ���� 24000203 
                             * Ŀǰ��������򵥵ķ�����
                             * HSSFCell cell = row.getCell(0);
                             * if(cell.getCellType == HSSFCell.CELL_TYPE_NUMERIC){
                             *     cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                             *     String cellValue = cell.toString();
                             * }
                             * */
                            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                            value = cell.getStringCellValue();
                            
                            for(int intA = 0; intA < intArray.length; intA++){  
                            	if(intArray[intA] == k){
                            		
                            		
                            		//value = "abc#123";
                            		int i = value.indexOf("@");
                            		if(i>0){
                            			//���ַ���
                            			String a[] = value.split("@"); 	
                            			value= a[0];
                            			//System.out.println(a[0]);
                            			//System.out.println(a[1]);
                            		}else{
                            			//-1
                            			//System.out.println("û��@����ַ���");
                            		}  
                            		
                            		linestr =linestr+"\'"+value+"\',";
                            	}
                            }                        
                            
                            //System.out.print(value+",");
                        }  
                        //rowMap.put(key, value);  
                    }  
                    //sheetList.add(rowMap);  
                    //System.out.println(linestr);
                    String strline = "INSERT INTO public.cus_application_list(application_name,product_id,service_name,product_name,product_code,cp, expenses_type)VALUES ("+linestr+");";
                    list.add(strline);
                }  
            }         
	    
	    } catch (FileNotFoundException e) {  
	        throw e;  
	    } finally {  
	        if (wb != null) {  
	            wb.close();  
	        }  
	        if (is != null) {  
	            is.close();  
	        }  
	    } 
	    
	    return list;
	}  
	
	

}
