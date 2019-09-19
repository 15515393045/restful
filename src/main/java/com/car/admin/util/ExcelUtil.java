package com.car.admin.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	//封装Excel导出
	public static XSSFWorkbook buildWorkbook(Class classz,List movieList,String sheetName,String[] headArr,String[] attrArr){
		//创建workbook
		XSSFWorkbook xwb = new XSSFWorkbook();
		//格式调整
		//时间
		XSSFCellStyle styleDate = xwb.createCellStyle();
		styleDate.setDataFormat(xwb.createDataFormat().getFormat("yyyy-MM-dd hh-mm-ss"));
		//精度
		XSSFCellStyle styleDouble = xwb.createCellStyle();
		styleDouble.setDataFormat(xwb.createDataFormat().getFormat("0.00"));
		//创建sheet
		XSSFSheet xs = xwb.createSheet(sheetName);
		XSSFRow crbt = xs.createRow(0);
		//根据下标循环创建标题
		for (int i = 0; i < headArr.length; i++) {
			crbt.createCell(i).setCellValue(headArr[i]);
		}
		
		//循环行列（单元格）和值
		for (int i = 0; i < movieList.size(); i++) {
			Object obj = movieList.get(i);
			//创建sheet中的行  注意：i+1出标题
			XSSFRow cr = xs.createRow(i+1);
			
			
			for (int j = 0; j < attrArr.length; j++) {
				String str = attrArr[j];
				//循环行中的列（单元格)
				XSSFCell cell = cr.createCell(j);
				try {
					Method method = classz.getMethod(buildGetMethod(str));
					Object result = method.invoke(obj);
					//cell.setCellValue(result);
					if(result instanceof Date){
						cell.setCellValue((Date)result);
						cell.setCellStyle(styleDate);
					}else if(result instanceof BigDecimal){
						cell.setCellValue(((BigDecimal) result).floatValue());
						cell.setCellStyle(styleDouble);
					}else{
						cell.setCellValue(String.valueOf(result));
					}
					
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		    }
		return xwb;
	}
	public static String buildGetMethod(String str){
		return "get"+str.substring(0, 1).toUpperCase()+str.substring(1);
	}
}
