package com.acti.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.acti.driver.DriverScript;
import com.acti.pages.EnterPage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskPage;
import com.acti.utils.ExcelLib;
import com.acti.utils.HelperLib;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest extends DriverScript {

	ExtentSparkReporter extent;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	
	LoginPage loginPage;
	EnterPage enterPage;
	TaskPage taskPage;
	
	@BeforeSuite
	public void setUpReport()
	{
		extent = new ExtentSparkReporter("./reports/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		DriverScript.initApplication();
		loginPage = new LoginPage();
		enterPage = new EnterPage();
		taskPage = new TaskPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", 
		    MediaEntityBuilder.createScreenCaptureFromPath(HelperLib.captureScreenshot(driver)).build());
		}
		report.flush();
		HelperLib.sleep();
		DriverScript.quitDriver();
	}
	
	@DataProvider(name="actiData")
	public Object[][] testData()
	{
		ExcelLib excel = new ExcelLib("./src/test/resources/testdata/actidata.xlsx");
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
