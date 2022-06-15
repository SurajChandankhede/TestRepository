package com.perficient.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver ldriver)
	{
		driver = ldriver;
		wait=new WebDriverWait(ldriver, 10);
	}
	
	@FindBy(xpath="//span[text()='MY ACCOUNT']") WebElement myAccount;
	
	@FindBy(xpath="//span[text()='Sign In']") WebElement signIn;
	
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement pwd;
	
	@FindBy(id="submit-btn") WebElement SignInButton;
	
	@FindBy(xpath="//span[contains(text(),"+"Forgot Password?"+")]") WebElement ForgotPwd;
	
	public void loginToFord(String username, String password)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			
		}*/
		myAccount.click();
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			
		}*/
		wait.until(ExpectedConditions.visibilityOf((signIn)));

		signIn.click();
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) 
		{
			
		}*/
		uname.sendKeys(username);
		pwd.sendKeys(password);
		SignInButton.click();
		
	}
	
}
