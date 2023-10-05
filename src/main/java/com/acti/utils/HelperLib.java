package com.acti.utils;

public class HelperLib {

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
