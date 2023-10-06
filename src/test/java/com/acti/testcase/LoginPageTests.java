package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;


/*
* class : LoginPageTests
* Description : Contains all the test cases related to actiTime loginPage
* Created Date : 09/19/2023
* Developed By : cpatel371@gmail.com
* Approved By : cpatel371@gmail.com
*/

public class LoginPageTests extends BaseTest{

	@Test(priority = 0)
	public void testLoginPageTitle()
	{
		logger = report.createTest("LoginPage Title Validation Test");
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Login"));
		logger.pass("Verified Login Page Title");
	}
	
	@Test(priority = 1,dataProvider = "actiData")
	public void testLoginFuncation(String username, String password) throws InterruptedException
	{
		logger = report.createTest("LoginPage Funcation Validation Test");
		loginPage.enterUsername(username);
		logger.info("entered username");
		loginPage.enterPassword(password);
		logger.info("entered password");
		loginPage.clickLoginbutton();
		logger.info("clicked login button");

		String actual = enterPage.getUserLoggedInText();
		Assert.assertTrue(actual.contains("John"));
		System.out.println(actual);
		logger.pass("Verified Login successfull");
		enterPage.clickLogout();
		logger.info("clicked logout link");
	}
	
	@Test(priority = 2)
	public void testActiImgDisplayed()
	{
		logger = report.createTest("Test ActiImg is Displayed");
		boolean flag = loginPage.isActiImageDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
		logger.pass("Verified actiimg is displayed");
	}
	
	@Test(priority = 3)
	public void testForgotPasswordLinkDisplayed()
	{
		logger = report.createTest("Test ForgotPasswordLink is Displayed");
		boolean flag = loginPage.isForgotPasswordLinkDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
		logger.pass("Verified forgotpassowrd is displayed");
	}
}
