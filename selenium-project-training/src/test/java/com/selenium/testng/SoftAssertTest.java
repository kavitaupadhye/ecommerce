package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

/*
 * @Author AutomationTest
 * This class contain code for soft assert 
 */

public class SoftAssertTest {

	WebDriver w;
	SoftAssert sft;

	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();

	}

	@Test(priority = 0, description = "Test case to verify home page functionality")
	public void homePageTest() {
		
		sft=new SoftAssert();

		w.get("https://www.zoopla.co.uk/");
		
		
		String pageTitle=w.getTitle();
		String pageUrl=w.getCurrentUrl();		
	    WebElement searchButton=w.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[2]/div/div[8]/button"));
		
		/****** Assertion code********/

	    sft.assertTrue(pageTitle.contains("gmail")  ,  "Title doesnt contains zoopla");
	    sft.assertEquals(pageUrl, "https://www.zoopla.co.uk");
	    sft.assertTrue(!searchButton.isDisplayed() , "Search button is not present");
		
	    sft.assertAll();
	}

	@Test(priority = 1, description = "Test case to verify Search functionality",dependsOnMethods = "homePageTest")
	public void verifySearchTest() throws Exception {

		sft=new SoftAssert();
		
		w.findElement(By.id("header-location")).sendKeys("London");
		w.findElement(By.xpath("//*[@id=\"__next\"]/main/div[1]/div[3]/div[2]/div/div[8]/button")).click();

		Thread.sleep(2000);		
		
		String pageTitle=w.getTitle();
		WebElement pageLabel=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[1]/h1"));
		
		
		/****** Assertion code********/
		sft.assertTrue(pageTitle.contains("London") , "Page title doesnt contains London");
		sft.assertEquals(pageLabel.getText(), "Property for sale in London");
		
		sft.assertAll();
	}

	@Test(priority = 2, description = "Test case to verify property detail functionality")
	public void propertyDetailTest() throws Exception {
		
		sft=new SoftAssert();
		
		String priceExpected=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[1]")).getText();
		String houseExpected=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[2]")).getText();
		String locationExpected=w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[3]")).getText();

		w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[2]"))
				.click();
		Thread.sleep(2000);
		
		
		
		WebElement priceActual=w.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div[1]/section[1]/div[1]/div[2]/span"));
		WebElement houseActual=w.findElement(By.xpath("//*[@id=\"listing-summary-details-heading\"]/span[1]"));
		WebElement locationActual=w.findElement(By.xpath("//*[@id=\"listing-summary-details-heading\"]/span[2]"));
		
		
		sft.assertEquals(priceActual.getText().trim(), priceExpected);
		sft.assertEquals(houseActual.getText().trim(), houseExpected);
		sft.assertEquals(locationActual.getText().trim(), locationExpected);
		
		System.out.println(priceActual.getText().trim()+" |||| "+ priceExpected);
		System.out.println(houseActual.getText().trim()+" |||| "+ houseExpected);
		System.out.println(locationActual.getText().trim()+" ||||  "+ locationExpected);

		sft.assertAll();
	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
