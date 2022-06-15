package com.perficient.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Screenshots, alerts, frames, windows, sync issues, javascript executor
	
	public static String captureScreenshot(WebDriver driver) 
	{
		File fi = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/Ford_"+getCurrentDateTime()+".png";
		try {
			//FileHandler.copy(fi, new File("./Screenshots/Ford"+getCurrentDateTime()+".png"));
			
			FileHandler.copy(fi, new File(screenshotpath));			
			System.out.println("Screenshot captured!!!");
			} 
		catch (Exception e) 
			{
				System.out.println("Not able to capture Screenshot "+e.getMessage());
			}
		return screenshotpath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customDateFormat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date date = new Date();
		
		return customDateFormat.format(date);		
	}
	
}
