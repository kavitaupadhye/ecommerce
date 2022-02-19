package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRMLoginTestCase {
	WebDriver w;

	@BeforeTest
	public void preCondition() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();

	}
	
	/**
	 * 
	 * @Author AutomationTester
	 *  
	 * thread is used
	 */
	
	@Test(priority = 0,description =  "Test case to verify 'admin' login functionality",groups="Login")
	public void loginAdmin() throws Exception {
 
		w.get("https://opensource-demo.orangehrmlive.com/");
		
		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		
		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
		
		w.findElement(By.cssSelector("input.button")).click();
		
		Thread.sleep(2000);
		
		w.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		
		w.findElement(By.linkText("Logout")).click();
	}
	
	
	
	
	
	
	

	@AfterTest
	public void postCondition() {
		w.quit();
	}

}
