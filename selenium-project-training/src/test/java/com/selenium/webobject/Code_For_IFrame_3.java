package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Code_For_IFrame_3 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test
	public void Code_For_IFrame_Test() throws Exception{
		
		w.get("http://demo.automationtesting.in/Frames.html");
		
		
		Thread.sleep(2000);
		
		
		WebElement singleframe=w.findElement(By.id("singleframe"));		
		
		w.switchTo().frame(singleframe);
		
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).clear();
		w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("automation ");
		
	/*	w.findElement(By.id("LOAN_AMOUNT")).clear();
		w.findElement(By.id("LOAN_AMOUNT")).sendKeys("400000");
		
		w.findElement(By.id("RATE_OF_INTEREST")).clear();
		w.findElement(By.id("RATE_OF_INTEREST")).sendKeys("9");

		w.findElement(By.id("LOAN_TENURE")).clear();
		w.findElement(By.id("LOAN_TENURE")).sendKeys("8");
		*/
		
	}

	@AfterTest
	public void afterTest() {
		//w.quit();
	}

}
