package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.driver.DriverScript;

/*
 * class : EnterPage - HomePage
 * Description : Manages all the home page elements and actions
 * Created Date : 9/19/2023
 * Developed By : cpatel371@gmail.com
 * Approved By : cpatel371@gmail.com
 */

public class EnterPage extends DriverScript{

	//****************************** Page Elements ******************************//
	
	@FindBy(id = "logoutLink") WebElement logoutLink;
	@FindBy(xpath = "//a[@class='userProfileLink username ']") WebElement userLoggedInText;
	@FindBy(xpath = "//a[@class='content tasks']") WebElement menuTask;

	//****************************** Page Elements Initialization******************************//

	// Page factory - it is a class in selenium which is used to initialized page elements
		
	public EnterPage()
		{
			PageFactory.initElements(driver, this);
		}
		
	//****************************** Page Elements Initialization******************************//

	public void clickTaskMenu()
	{
		menuTask.click();
	}
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public String getUserLoggedInText()
	{
		return userLoggedInText.getText();
	}
	
	
	
}
