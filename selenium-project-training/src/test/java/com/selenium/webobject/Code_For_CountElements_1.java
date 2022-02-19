package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements_1 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		w = new ChromeDriver();
		w.manage().window().maximize();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception {

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);

		// Count number of radio button on web page.

		List<WebElement> radioCount = w.findElements(By.name("radiooptions"));
		System.out.println("Radio button count : " + radioCount.size());

		// Count number of checkbox on web page.

		List<WebElement> checkboxCount = w.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Checkbox count : " + checkboxCount.size());

		// Count number of links on web page.

		List<WebElement> linksCount = w.findElements(By.tagName("a"));
		System.out.println("links count : " + linksCount.size());

		// Count number of drop down on web page.

		List<WebElement> dropdownCount = w.findElements(By.tagName("select"));
		System.out.println("drop down count : " + dropdownCount.size());
		
	/*************************************************************************************************/			
		
		WebElement monthDropDown=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));		
		Select sel=new Select(monthDropDown);
		
		sel.selectByVisibleText("March");
		
		List <WebElement> monthOptions=sel.getOptions(); //Array
		
		System.out.println(monthOptions);
		
		//for each loop
		
		for(WebElement monthValue : monthOptions ) {
			
			System.out.println(monthValue.getText());
		}		
		
	
		
		for(int i=0;i<monthOptions.size();i++) {
			
			System.out.println(monthOptions.get(i).getText());
		}
		
	}

	@AfterTest
	public void afterTest() {

		w.quit();
	}

}
