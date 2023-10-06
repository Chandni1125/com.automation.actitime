package com.acti.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperLib {

	/*
	 * this method is to capture the screenshot on failure
	 */
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenPath = "C:/Users/surat/git/com.automation.actitime/reports/screens"+".png";
		try
		{
		FileHandler.copy(src, new File(screenPath));
	}catch(IOException e)
		{
		e.printStackTrace();
		}
		return screenPath;
	}
	
	public static void sleep()
	{
		try
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
