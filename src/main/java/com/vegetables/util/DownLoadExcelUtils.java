package com.vegetables.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DownLoadExcelUtils {


    /**
     * 财务相关Excel适用
     * @param list  数据集
     * @param response
     * @param fileNameDate 下载到客户端excel文件名称日期前缀
     * @throws Exception
     */
    public static void downFinanceExcel(List<Map<String,Object>> list, HttpServletResponse response,String fileNameDate) throws Exception{
        String serpath = PathUtil.getClassResources() + "static/template/finance.xls";
        FileInputStream fs=new FileInputStream(serpath);  //获取d://test.xls
        POIFSFileSystem ps=new POIFSFileSystem(fs);  //使用POI提供的方法得到excel的信息
        HSSFWorkbook wb=new HSSFWorkbook(ps);
        HSSFSheet sheet=wb.getSheetAt(0); //获取到工作表，因为一个excel可能有多个工作表
        sheet.setColumnWidth(0, 5000); //设置列宽
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 8000);
        sheet.setColumnWidth(3, 10000);
        sheet.setColumnWidth(4, 8000);

        //给行定制样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont font = wb.createFont();
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 18);// 设置字体大小
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
        style.setFont(font);

        //合并单元格
        CellRangeAddress cra=new CellRangeAddress(0, 0, 0, 4);
        sheet.addMergedRegion(cra);
        HSSFRow row1=sheet.getRow(0);
        row1=sheet.createRow((short)(0)); //在现有行号后追加数据
        row1.setHeightInPoints((short) 39);  //设置行高
        HSSFCell cell = row1.createCell((short) 0);
        cell.setCellValue(DateUtils.format(new Date())+" 清单");
        //设置单元格居中
        HSSFCellStyle cellStyle = wb.createCellStyle(); //新建单元格样式
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直
        cell.setCellStyle(cellStyle);

        //设置列头
        HSSFRow row2=sheet.getRow(1); //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
        row2=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据
        row2.createCell((short) 0).setCellValue("账单类型"); //设置第一个（从0开始）单元格的数据
        row2.createCell((short) 1).setCellValue("金额"); //设置第一个（从0开始）单元格的数据
        row2.createCell((short) 2).setCellValue("账单记录日期"); //设置第二个（从0开始）单元格的数据
        row2.createCell((short) 3).setCellValue("备注"); //设置第二个（从0开始）单元格的数据
        row2.createCell((short) 4).setCellValue("创建日期"); //设置第二个（从0开始）单元格的数据
        row2.getCell((short)0).getCellStyle().setAlignment(HSSFCellStyle.ALIGN_CENTER);
        row2.getCell((short)1).getCellStyle().setAlignment(HSSFCellStyle.ALIGN_CENTER);
        row2.getCell((short)2).getCellStyle().setAlignment(HSSFCellStyle.ALIGN_CENTER);
        row2.getCell((short)3).getCellStyle().setAlignment(HSSFCellStyle.ALIGN_CENTER);
        row2.getCell((short)4).getCellStyle().setAlignment(HSSFCellStyle.ALIGN_CENTER);
        row2.setRowStyle(style);

        for(int i = 0;i<list.size();i++){
            Map<String,Object> temp = list.get(i);
            //普通往单元格写内容
            HSSFRow row=sheet.getRow(i+2); //获取第一行（excel中的行默认从0开始，所以这就是为什么，一个excel必须有字段列头），即，字段列头，便于赋值
            row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //在现有行号后追加数据
            row.createCell((short) 0).setCellValue(temp.get("type_name").toString()); //设置第一个（从0开始）单元格的数据
            row.createCell((short) 1).setCellValue(temp.get("finance_amount").toString()); //设置第一个（从0开始）单元格的数据
            row.createCell((short) 2).setCellValue(temp.get("finance_date").toString()); //设置第二个（从0开始）单元格的数据
            row.createCell((short) 3).setCellValue(temp.get("finance_reason").toString()); //设置第二个（从0开始）单元格的数据
            row.createCell((short) 4).setCellValue(temp.get("create_time").toString()); //设置第二个（从0开始）单元格的数据
        }

        response.reset();
        String fileName = "attachment;filename=\"" + fileNameDate + "财务清单.xls" + "\"";
        response.setHeader("Content-disposition", new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        response.setContentType("application/octet-stream;charset=UTF-8");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        response.flushBuffer();
    }


}
