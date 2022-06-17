package com.perficient.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.perficient.utilities.BrowserFactory;
import com.perficient.utilities.ConfigDataProvider;
import com.perficient.utilities.ExcelDataProvider;
import com.perficient.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public WebDriverWait wait;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentSparkReporter extent;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		Reporter.log("setting up reports and test is getting ready",true);
		excel = new ExcelDataProvider();
		config=new ConfigDataProvider();
		extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/login_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("settings done - test can be started",true);

	}
		
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void setup(String browser, String url)
	{
		Reporter.log("Trying to start browser and application is getting ready",true);

		//driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getProdURL());
		
		driver=BrowserFactory.startApplication(driver, browser, url);
		wait = new WebDriverWait(driver, 10);
		Reporter.log("Application Launched",true);

	}
	
	@AfterClass
	public void teardown()
	{
		BrowserFactory.quitBrowser(driver);

	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result)
	{
		Reporter.log("Test is about to End",true);

		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			Helper.captureScreenshot(driver);
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			Helper.captureScreenshot(driver);
			logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed Reports generated",true);

	}
	
	
}
