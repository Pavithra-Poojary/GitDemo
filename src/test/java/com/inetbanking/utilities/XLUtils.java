package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow wr;
public static XSSFCell fc;

public static int getRowCount(String xlfile,String xlsheet)throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	int rowcount=ws.getLastRowNum();
	wb.close();
	fi.close();
	return rowcount;
}

public static int getCellCount(String xlfile,String xlsheet,int cellcount)throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	int rownum = 0;
	wr=ws.getRow(rownum);
	 cellcount=wr.getLastCellNum();
	wb.close();
	fi.close();
	return cellcount;
}

public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
{
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	wr=ws.getRow(rownum);
	fc=wr.getCell(colnum);
	
	return xlsheet;
	
}
public static String setCellData(String xlfile,String xlsheet,int rownum,int colnum,String Data) throws IOException {
	fi=new FileInputStream(xlfile);
	wb=new XSSFWorkbook(fi);
	ws=wb.getSheet(xlsheet);
	wr=ws.getRow(rownum);
	XSSFCell cell = wr.createCell(colnum);
	cell.setCellValue(Data);
	fo=new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	fi.close();
	fo.close();
	return null;	
}
}
