package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib 
{
	XSSFWorkbook test1;
	//constructor
	public ExcelLib(String ExcelPath)
	{
	try 
	{
		File source = new File(ExcelPath);
		FileInputStream test = new FileInputStream(source);
		test1 = new XSSFWorkbook(test);
	}
	catch(Exception e)
	
	{
		System.out.println("Unable to load the excel file"+e.getMessage());
	}
	
}
	//to count the row numbers of a sheet using excel sheet number
	public int getRowCount(int sheetnum)
	{
		int count = test1.getSheetAt(sheetnum).getLastRowNum()+1;
		return count;
	}
	//to count the row numbers of a sheet using excel sheet name
	public int getRowCount(String sheetName)
	{
		int count = test1.getSheet(sheetName).getLastRowNum()+1;
		return count;
	}
	
	//to get data of a cell using sheet number
	public String getCellData(int sheetnum, int rowNum, int colNum)
	{
		String data = test1.getSheetAt(sheetnum).getRow(rowNum).getCell(colNum).toString();
		return data;
	}
	//to get data of a cell using sheet name
	public String getCellData(String sheetname, int rowNum, int colNum)
	{
		String data = test1.getSheet(sheetname).getRow(rowNum).getCell(colNum).toString();
		return data;
	}
	
}

