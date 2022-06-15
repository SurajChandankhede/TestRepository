package com.perficient.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.perficient.pages.BaseClass;
import com.perficient.pages.LoginPage;
import com.perficient.utilities.Helper;

public class LoginTestCRM extends BaseClass {
	
	@Test(priority=1)
	public void loginApp()
	{
		logger = report.createTest("Login to Ford");
		
		logger.info("Starting login page");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.loginToFord(excel.getStringData(0, 0, 0), excel.getStringData(0, 0, 1));
		Helper.captureScreenshot(driver);
		logger.pass("Login Success");
	}
	
@Test(priority=2)
public void loginApp1()
{
	logger = report.createTest("Logout");
	logger.fail("logout failed");
}
	
}
