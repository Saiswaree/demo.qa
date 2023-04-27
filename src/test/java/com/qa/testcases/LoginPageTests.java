package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.EnterPage;
import com.qa.pages.LoginPage;
import com.qa.rsi.DriverScript;

public class LoginPageTests extends DriverScript {

	@Test(priority = 1)

	public void testLoginPageTitle() throws InterruptedException 
	{
		initApplication();
		LoginPage lp = new LoginPage();
		String Expected="actiTIME - Login";
		String actual = lp.getLoginPageTitle();
		Assert.assertEquals(actual, Expected);
		quitDriver();
	}
	@Test(priority = 2)
	public void testActiImageIsDisplayed() throws InterruptedException 
	{
		initApplication();
		LoginPage logo = new LoginPage(); 
		boolean flag = logo.verifyActiLogo();
		Assert.assertTrue(flag);
		quitDriver();
	}
	@Test(priority = 3)
	public void forgotPasswordIsDisplayed() throws InterruptedException
	{
		initApplication();
		LoginPage fp = new LoginPage();
		boolean act = fp.verifyForgotPassword();
		Assert.assertTrue(act);
		quitDriver();
	}
	
	@Test(priority = 4)
	public void loginFunctionality() throws InterruptedException
	{
		initApplication();
		LoginPage lb = new LoginPage(); 
		lb.enterUsername("admin");
		lb.enterPassword("manager");
		lb.clickLogin();
		EnterPage ep = new EnterPage();
		String expected="John Doe";
		String actual = ep.verifyUserLoggedIn();
		Assert.assertEquals(actual, expected);
		ep.clickLogout();
		quitDriver();
		
	}
}
