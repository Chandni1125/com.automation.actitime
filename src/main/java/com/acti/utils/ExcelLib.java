package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {

    XSSFWorkbook wb;
	
	/*
	 * Constructor which initialize the excel source path and file input stream 
	 */
	public ExcelLib(String excelPath) 
	{
	try
	{
		File src = new File(excelPath);
		FileInputStream fis=new FileInputStream(src);
	    wb = new XSSFWorkbook(fis);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("unable to the excel. please check the path "+e.getMessage());	
	}
}
	
	/*
	 * this method is used to get the active rows count
	 */
	
	public int getRowCount(int sheetNo) 
	{
		int count = wb.getSheetAt(sheetNo).getLastRowNum()+1;
		return count;	
	}
	
	public int getRowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum()+1;
	}
	
	/*
	 * this method is used to get the cell data
	 */
	
	public String getCellData(int sheetNo, int rowNo, int colNo)
	{
		String data = wb.getSheetAt(sheetNo).getRow(rowNo).getCell(colNo).toString();
		return data;
	}
	
	public String getCellData(String sheetName, int rowNo, int colNo)
	{
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).toString();
	}
	

}

