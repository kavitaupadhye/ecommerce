package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.*;

public class MutualFundLoginTestCase {
	WebDriver w;

	@BeforeClass
	public void preCondition() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();

	}
	
	/**
	 * 
	 * @Author AutomationTester
	 * Test case for admin, tuser,sppeed login used id and xpath as locator and 2 sec 
	 * thread is used
	 */
	
	@Test(priority = 0,description =  "Test case to verify 'admin' login functionality",groups="Login")
	public void loginAdmin() throws Exception {
 
		w.get("http://www.altoromutual.com/login.jsp");

		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000); 
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 1,description = "Test case to verify 'tuser' login functionality",dependsOnMethods = "loginAdmin",groups="Login",invocationCount = 3 ,enabled = false)
	public void loginTestUser() throws Exception {
 
		w.get("http://www.altoromutual.com/login.jsp");

		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.id("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000); 
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Thread.sleep(2000);
	}
	
	
	
	@Test(priority = 2,description = "Test case to verify 'sspeed' login functionality",dependsOnMethods = "loginAdmin",groups="Login",enabled = true)
	public void loginSpeed() throws Exception {
 
		w.get("http://www.altoromutual.com/login.jsp");

		w.findElement(By.id("uid")).sendKeys("sspeed");
		w.findElement(By.id("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000); 
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void postCondition() {
		w.quit();
	}

}
