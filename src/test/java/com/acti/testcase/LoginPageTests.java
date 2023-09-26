package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acti.driver.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;


/*
* class : LoginPageTests
* Description : Contains all the test cases related to actiTime loginPage
* Created Date : 09/19/2023
* Developed By : cpatel371@gmail.com
* Approved By : cpatel371@gmail.com
*/

public class LoginPageTests extends DriverScript{

	LoginPage loginPage;
	EnterPage enterPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		DriverScript.initApplication();
		loginPage = new LoginPage();
		enterPage = new EnterPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		DriverScript.quitDriver();
	}
	
	
	
	@Test
	public void testLoginFuncation() throws InterruptedException
	{
		loginPage.enterUsername("admin");
		loginPage.enterPassword("manager");
		loginPage.clickLoginbutton();
		
		String actual = enterPage.getUserLoggedInText();
		Assert.assertTrue(actual.contains("John"));
		System.out.println(actual);
		enterPage.clickLogout();

	}
}
