package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.qa.pages.EnterPage;
import com.qa.pages.LoginPage;
import com.qa.rsi.DriverScript;
import com.qa.utils.ExcelLib;

public class BaseTest extends DriverScript{

	LoginPage lp;
	EnterPage ep;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initApplication();
		lp = new LoginPage(); 
		ep = new EnterPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}
	@DataProvider(name="actilogin")
	public Object[][] testdata()
	{
		ExcelLib excel = new ExcelLib("./atTestData/actiData.xlsx");
		int count = excel.getRowCount(0);
		
		
		Object[][] data = new Object[count][2];
		for(int i=0;i<count;i++)
		{
		data[i][0]=excel.getCellData(0, i, 0);
		data[i][1]=excel.getCellData(0, i, 1);
		}
		
		
	return data;	
	}
}
