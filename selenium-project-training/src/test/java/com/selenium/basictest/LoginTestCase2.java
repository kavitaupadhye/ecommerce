package com.selenium.basictest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTestCase2 {
	WebDriver w;

	@BeforeTest
	public void preCondition() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();

	}

	@Test(priority = 0, description = "Test case to verify home page", groups = "Login")
	public void loginAdmin() throws Exception {

		w.get("https://www.zoopla.co.uk/");

		String pageTitle = w.getTitle();
		String pageURL = w.getCurrentUrl();

		WebElement searchButton = w.findElement(By.xpath("//button[text()='Search']"));

		Assert.assertTrue(pageTitle.contains("Zoopla"));
		Assert.assertEquals(pageURL, "https://www.zoopla.co.uk/");
		Assert.assertTrue(searchButton.isDisplayed(), "Search button not present");

	}

	@Test(priority = 1, description = "Test case to verify search functionality")
	public void loginTestUser() throws Exception {

		w.findElement(By.id("header-location")).sendKeys("London");
		w.findElement(By.xpath("//button[text()='Search']")).click();
		Thread.sleep(2000);

		String pageTitle = w.getTitle();
		WebElement pageLabel = w.findElement(By.cssSelector("span.breadcrumb_no_append"));

		Assert.assertTrue(pageTitle.contains("London"));
		Assert.assertEquals(pageLabel.getText(), "London property for sale");
	}

	@Test(priority = 2, description = "Test case to verify select property data")
	public void loginSpeed() throws Exception {
		String price = w
				.findElement(
						By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[1]"))
				.getText();
		String houseDetail = w
				.findElement(
						By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[2]"))
				.getText();
		String address = w
				.findElement(
						By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[3]"))
				.getText();

		System.out.println(
				"On Seacrh page : Price = " + price + "\nHouse details = " + houseDetail + "\nAddress = " + address);

		w.findElement(By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/main/div[2]/div[1]/a[1]/div/div[2]/div[1]/p[1]"))
				.click();
		Thread.sleep(2000);

		String priceOnDetailPage = w.findElement(By.cssSelector("span[data-testid='price']")).getText();
		String houseOnDetailPage = w.findElement(By.cssSelector("span[data-testid='title-label']")).getText();
		String addressOnDetailPage = w.findElement(By.cssSelector("span[data-testid='address-label']")).getText();

		
		System.out.println(
				"\n\nOn Detail page : Price = " + priceOnDetailPage + "\nHouse details = " + houseOnDetailPage + "\nAddress = " + addressOnDetailPage);

		Assert.assertEquals(addressOnDetailPage.trim(), address);
		Assert.assertEquals(houseOnDetailPage.trim(), houseDetail);
		Assert.assertEquals(priceOnDetailPage.trim(), price);

		
	}

	@AfterTest
	public void postCondition() {
		 w.quit();
	}

}
