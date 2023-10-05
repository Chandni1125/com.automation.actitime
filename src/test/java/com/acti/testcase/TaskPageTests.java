package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskPageTests extends BaseTest{

	@Test
	public void testCreateNewCustomer()
	{
		loginPage.enterUsername("admin");
		loginPage.enterPassword("manager");
		loginPage.clickLoginbutton();
		enterPage.clickTaskMenu();
		taskPage.clickAddNewButton();
		taskPage.clickItemNewCustomer();
		taskPage.enterCustomerName("Automation");
		taskPage.enterCustomerDescription("Selenium Webdriver");
		taskPage.clickCustomerButton();
		String msg = taskPage.getSuccessMessageText();
		System.out.println(msg);
		Assert.assertTrue(msg.contains("created"));
	}
	
	@Test
	public void testDeleteCustomer()
	{
		loginPage.enterUsername("admin");
		loginPage.enterPassword("manager");
		loginPage.clickLoginbutton();
		String actual = enterPage.getUserLoggedInText();
		Assert.assertTrue(actual.contains("John"));
		enterPage.clickTaskMenu();
		taskPage.enterCustomerType("Automation");
		taskPage.clickSearchedCustomer();
		taskPage.clickEditButton();
		taskPage.clickActionButton();
		taskPage.clickDeleteButton();
		taskPage.clickDeletePermanently();
		String msg = taskPage.getSuccessMessageText();
		Assert.assertTrue(msg.contains("deleted"));
	}
	
	
}
