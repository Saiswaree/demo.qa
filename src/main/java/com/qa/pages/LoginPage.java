package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rsi.DriverScript;

/*
 * Class: LoginPage
 * Login Page Elements and Actions
 * Developed by: Sai
 * Date: 4/25/2023
 * Reviewed by: Manager
 */

public class LoginPage extends DriverScript {

// *********************************Page Elements*************************************************

	@FindBy(id = "username")WebElement usernameTextbox;
	@FindBy(name = "pwd") WebElement passwordTextbox;
	@FindBy(xpath = "//div[text()='Login ']")WebElement loginButton;
	@FindBy(linkText = "Forgot your password?") WebElement forgotPasswordLink;
	@FindBy(className="atLogoImg") WebElement actiImage;

//**************************Page Initialization****************************************************
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//****************************Page Method/Actions**************************************************
	public void enterUsername(String username)
	{
		usernameTextbox.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextbox.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	public boolean verifyForgotPassword()
	{
		return forgotPasswordLink.isDisplayed();
	}
	
	public boolean verifyActiLogo()
	{
		return actiImage.isDisplayed();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
}