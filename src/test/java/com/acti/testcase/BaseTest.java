package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.acti.driver.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;

public class BaseTest extends DriverScript {

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
	
}
