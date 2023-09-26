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
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Login"));
	}
	
	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void testActiImgDisplayed()
	{
		boolean flag = loginPage.isActiImageDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void testForgotPasswordLinkDisplayed()
	{
		boolean flag = loginPage.isForgotPasswordLinkDisplayed();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
}
