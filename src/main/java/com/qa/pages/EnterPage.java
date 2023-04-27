package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.rsi.DriverScript;

/*
 * Class: EnterPage
 * Enter Page Elements and Actions
 * Developed by: Sai
 * Date: 4/25/2023
 * Reviewed by: Manager
 */


		public class EnterPage extends DriverScript{
	// *********************************Page Elements*************************************************

		@FindBy(xpath = "//a[@class='userProfileLink username ']")WebElement usernameText;
		@FindBy(id = "logoutLink")WebElement logoutLink;
	//**************************Page Initialization****************************************************
		
		
		public EnterPage()
		{
			PageFactory.initElements(driver, this);
		}
		
	//****************************Page Method/Actions**************************************************
		
public String verifyUserLoggedIn()
{
	return usernameText.getText();
}
public String getEnterPageTitle()
{
	return driver.getTitle();
}
public void clickLogout()
{
	logoutLink.click();
}
}
