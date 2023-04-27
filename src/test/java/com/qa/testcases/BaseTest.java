package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.pages.EnterPage;
import com.qa.pages.LoginPage;
import com.qa.rsi.DriverScript;

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
}
