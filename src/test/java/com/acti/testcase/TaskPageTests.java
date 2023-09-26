package com.acti.testcase;

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
		taskPage.enterCustomerName("Test Chandni");
		taskPage.enterCustomerDescription("Automation");
		taskPage.clickCustomerButton();
		String msg = taskPage.getSuccessMessageText();
		System.out.println(msg);
	}
	
	
}
