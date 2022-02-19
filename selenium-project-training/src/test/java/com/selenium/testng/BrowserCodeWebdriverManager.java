package com.selenium.testng;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class BrowserCodeWebdriverManager {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {
	}

	@Test(priority = 0, description = "Test chrome browser")
	public void chromeBrowser() throws Exception {

		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		w.quit();
	}

	@Test(priority = 1, description = "Test firefox browser")
	public void firefoxBrowser() throws Exception {

		WebDriverManager.firefoxdriver().setup();
		w = new FirefoxDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
		// w.quit();
	}

	@Test(priority = 2, description = "Test edge browser")
	public void edgeBrowser() throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		w = new EdgeDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
	}

	@Test(priority = 3, description = "Test internet explorer browser")
	public void internetExplorerBrowser() throws InterruptedException {

		WebDriverManager.iedriver().setup();
		w = new InternetExplorerDriver();
		w.get("https://www.google.com/");
		Thread.sleep(2000);
	}

	@AfterTest
	public void afterTest() {
	}

}
