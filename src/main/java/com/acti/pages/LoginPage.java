package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverScript;

/*
* class : LoginPage
* Description : Manages all the login page elements and actions
* Created Date : 09/19/2023
* Developed By : cpatel371@gmail.com
* Approved By : cpatel371@gmail.com
*/

public class LoginPage extends DriverScript{
	
//****************************** Page Elements ******************************//

	@FindBy(id = "username") WebElement usernameTB;
	@FindBy(name = "pwd") WebElement passwordTB;
	@FindBy(xpath = "//div[text()='Login ']") WebElement loginBtn;
	@FindBy(className = "atLogoImg") WebElement actiImg;
	@FindBy(linkText = "Forgot your password?1111") WebElement forgotpasswordLink;
	
//****************************** Page Elements Initialization******************************//

	// Page factory - it is a class in selenium which is used to initialized page elements
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//****************************** Page Elements Initialization******************************//

	public void enterUsername(String username)
	{
		usernameTB.sendKeys(username);
	}

	public void enterPassword(String password)
	{
		passwordTB.sendKeys(password);
	}
	
	public void clickLoginbutton()
	{
		loginBtn.click();
	}
	
	public boolean isActiImageDisplayed()
	{
		return actiImg.isDisplayed();
	}
	
	public boolean isForgotPasswordLinkDisplayed()
	{
		return forgotpasswordLink.isDisplayed();
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	
	
	
	
}
 