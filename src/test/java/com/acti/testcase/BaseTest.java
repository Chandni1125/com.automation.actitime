package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.acti.driver.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;
import com.acti.utils.ExcelLib;

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
	
	@DataProvider(name="actiData")
	public Object[][] testData()
	{
		ExcelLib excel = new ExcelLib("./src/main/resources/testdata/actidata.xlsx");
		int rows = excel.getRowCount("usercredentials");
		Object data[][]=new Object[rows][2];
		
		for(int i=0; i<rows; i++)
		{
			data[i][0]=excel.getCellData("usercredentials", i, 0);
			data[i][1]=excel.getCellData("usercredentials", i, 1);

		}
		//Object[][] data = new Object[rows][2];
		//data[0][0]="admin";
		//data[0][1]="manager";
		
		//data[1][0]="admin";
		//data[1][1]="manager";

		return data;
	}
	
}
