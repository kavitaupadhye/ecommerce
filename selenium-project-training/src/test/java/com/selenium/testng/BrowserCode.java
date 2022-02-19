package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class BrowserCode {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {
	}

	@Test(priority = 0, description = "Test chrome browser")
	public void chromeBrowser() throws Exception {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		
		w = new ChromeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	}

	@Test(priority = 1, description = "Test firefox browser")
	public void firefoxBrowser() throws Exception {
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\BrowserDriver\\geckodriver.exe");
		w = new FirefoxDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
	//	w.quit();
	}

	@Test(priority = 2, description = "Test edge browser")
	public void edgeBrowser() throws InterruptedException {
		
         String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver", projectPath + "\\BrowserDriver\\msedgedriver.exe");
		w = new EdgeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
	}
	
	
	@Test(priority = 3, description = "Test internet explorer browser")
	public void internetExplorerBrowser() throws InterruptedException {
		
         String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.ie.driver", projectPath + "\\BrowserDriver\\IEDriverServer.exe");
		w = new InternetExplorerDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
	}

}
