package com.vegetables.util;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * 下载文件
 * 创建人：FH Q313596790
 * 创建时间：2014年12月23日
 * @version
 */
public class FileDownload {

	/**
	 * @param response 
	 * @param filePath		//文件完整路径(包括文件名和扩展名)
	 * @param fileName		//下载后看到的文件名
	 * @return  文件名
	 */
	public static void fileDownload(final HttpServletResponse response, String filePath, String fileName) throws Exception{  
		   
		byte[] data = FileUtil.toByteArray2(filePath);  
	    fileName = URLEncoder.encode(fileName, "UTF-8");  
	    response.reset();  
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  
	    response.addHeader("Content-Length", "" + data.length);  
	    response.setContentType("application/octet-stream;charset=UTF-8");  
	    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  
	    outputStream.write(data);  
	    outputStream.flush();  
	    outputStream.close();
	    response.flushBuffer();
	} 
	
	/**
	 * 下载excel,在狐火下名称不乱码
	 * @param response 
	 * @param filePath		//文件完整路径(包括文件名和扩展名)
	 * @param fileName		//下载后看到的文件名
	 * @return  文件名
	 */
	public static void fileDownload(final HttpServletResponse response ,final HttpServletRequest request, String filePath, String fileName) throws Exception{  
		   
		byte[] data = FileUtil.toByteArray2(filePath);  
		final String userAgent = request.getHeader("USER-AGENT"); 
		String finalFileName = null;  
		if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器  
            finalFileName = URLEncoder.encode(fileName,"UTF8");  
        }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器  
            finalFileName = new String(fileName.getBytes(), "ISO8859-1");  
        }else{  
            finalFileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器  
        }  
	    fileName = URLEncoder.encode(fileName, "UTF-8");  
        
	    response.reset();  
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\""); //这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开   
	    response.addHeader("Content-Length", "" + data.length);  
	    response.setContentType("application/vnd.ms-excel"); 
	    //response.setContentType("application/octet-stream;charset=UTF-8");  
	    OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  
	    outputStream.write(data);  
	    outputStream.flush();  
	    outputStream.close();
	    response.flushBuffer();
	} 
	
	
	/**
	 * 11.6功能流程:(服务器excel为两份，一份用来做覆盖操作,一份用来追加数据)
	 * 		客户点击下载模板时，开始往服务器的excel中追加行,行从数据库查,
	 * 		数据往服务器excel追加好后,下载到客户端，然后读取模板excel,覆盖客户下载的excel,保证excel为新的
	 * @param args
	 */
	public static void main(String[] args) throws Exception {    
        FileInputStream fs=new FileInputStream("e://test.xls");  //获取d://test.xls  
        POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息  
        HSSFWorkbook wb=new HSSFWorkbook(ps);    
        HSSFSheet sheet=wb.getSheetAt(0);  //获取到工作表，因为一个excel可能有多个工作表  
        HSSFRow row=sheet.getRow(1);  //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值  
        System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());  //分别得到最后一行的行号，和一条记录的最后一个单元格  
          
        FileSystemView fsv = FileSystemView.getFileSystemView();
        String path = fsv.getHomeDirectory().getPath();
        path = path.replaceAll("\\\\", "/");
        FileOutputStream out=new FileOutputStream(path+"/test1.xls");  //向d://test.xls中写数据  
        row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据  
        row.createCell((short) 0).setCellValue("leilei"); //设置第一个（从0开始）单元格的数据  
        row.createCell((short) 1).setCellValue(24); //设置第二个（从0开始）单元格的数据  
        row.createCell((short) 2).setCellValue(25);
        row.createCell((short) 3).setCellValue(26);
        out.flush();  
        wb.write(out);    
        out.close();    
        System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());    
    } 
	
}
