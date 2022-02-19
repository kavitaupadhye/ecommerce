package com.selenium.basictest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestCase {
	WebDriver w;
	EventFiringWebDriver ef;

	@BeforeTest
	public void preCondition() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		ef=new EventFiringWebDriver(w);
		
	}

	@Test(priority = 0, description = "Test case to verify home page", groups = "Login")
	public void loginAdmin() throws Exception {

		ef.get("https://www.zoopla.co.uk/");

		String pageTitle = w.getTitle();
		String pageURL = w.getCurrentUrl();

		WebElement searchButton = ef.findElement(By.xpath("//button[text()='Search']"));

		Assert.assertTrue(pageTitle.contains("Zoopla"));
		Assert.assertEquals(pageURL, "https://www.zoopla.co.uk/");
		Assert.assertTrue(searchButton.isDisplayed(), "Search button not present");

	}

	@Test(priority = 1, description = "Test case to verify search functionality")
	public void loginTestUser() throws Exception {

		ef.findElement(By.id("header-location")).sendKeys("London");
		ef.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(2000);

		String pageTitle = ef.getTitle();
		WebElement pageLabel = ef.findElement(By.cssSelector("span.breadcrumb_no_append"));

		Assert.assertTrue(pageTitle.contains("London"));
		Assert.assertEquals(pageLabel.getText(), "London property for sale");
	}

	

	@AfterTest
	public void postCondition() {
		ef.quit();
	}

}
