package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;

public class LoginPageTests extends BaseTest {

	@Test

	public void testLoginPageTitle() throws InterruptedException {

		LoginPage lp = new LoginPage();
		String Expected = "actiTIME - Login";
		String actual = lp.getLoginPageTitle();
		Assert.assertEquals(actual, Expected);

	}

	@Test
	public void testActiImageIsDisplayed() throws InterruptedException {

		boolean flag = lp.verifyActiLogo();
		Assert.assertTrue(flag);

	}

	@Test
	public void forgotPasswordIsDisplayed() throws InterruptedException {

		boolean act = lp.verifyForgotPassword();
		Assert.assertTrue(act);

	}

	@Test
	public void loginFunctionality() throws InterruptedException {

		lp.enterUsername("admin");
		lp.enterPassword("manager");
		lp.clickLogin();
		String expected = "John Doe";
		String actual = ep.verifyUserLoggedIn();
		Assert.assertEquals(actual, expected);
		ep.clickLogout();

	}
}
