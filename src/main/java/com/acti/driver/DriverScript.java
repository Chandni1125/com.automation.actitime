package com.acti.driver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * class : DriverScript
 * Description : Manages all the driver instance
 * Developed By : cpatel371@gmail.com
 * Approved By : cpatel371@gmail.com
 */
public class DriverScript {
	
	public static WebDriver driver;
	static Properties prop;

	
	/*
	 * Constructor which loads the properties file
	 */
	public DriverScript()
	{
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load the properties file please check "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//@Test

	/*
	 * this method loads the browser from properties files also called as getURL method
	 */
	public static void initApplication() throws InterruptedException 
	{
		String browser = prop.getProperty("Browser");
		
		if(browser.trim().equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.trim().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.trim().equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("The browser value is not supported. Please check the config file");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
		getURL();
		
	}
	/*
	 * this method load the url data from properties file
	 */
	
	public static void getURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	/*
	 * this method is to quit or close the driver
	 */
	public static void quitDriver()
	{
		driver.quit();
	}
	
}
