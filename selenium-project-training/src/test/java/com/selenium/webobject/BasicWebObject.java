package com.selenium.webobject;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject {
	WebDriver w;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Test case to handle textbox")
	public void handleTextBox()throws Exception {
		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		//FirstName		
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Jones");
		
		
		//LastName
		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Smith");
		
		
		//Address 
		
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("sample test address");
		
		
		//Email 
		
		w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).clear();
		w.findElement(By.cssSelector("input[ng-model='EmailAdress']")).sendKeys("test@gmail.com");
		
		
		//Mobile Number  //          tagname[attribute='data']
		w.findElement(By.cssSelector("input[ng-model='Phone']")).clear();
		w.findElement(By.cssSelector("input[ng-model='Phone']")).sendKeys("9898989898");
	
		
	}
	
	@Test(priority = 1,description = "Test case to radio button")
	public void handleRadioButton()throws Exception {
		
		w.findElement(By.cssSelector("input[value='Male']")).click();
	}
	
	@Test(priority = 2,description = "Test case to checkbox")
	public void handleCheckBox()throws Exception {
		
		w.findElement(By.id("checkbox1")).click();
		w.findElement(By.id("checkbox2")).click();
		w.findElement(By.id("checkbox3")).click();

	}
	

	
	
	@Test(priority = 3,description = "Test case to handle drop-down list")
	public void handleDropDownList()throws Exception {
		
		WebElement SkillsDropDown=w.findElement(By.id("Skills"));
		
		Select sel=new Select(SkillsDropDown);
		
		//ByIndex		
		//sel.selectByIndex(5);
		
		//ByValue		
		//sel.selectByValue("Analytics");
		
		//ByVisibleText
		sel.selectByVisibleText("Java");
		
		

	}
	
	
	@AfterTest
	public void afterTest() {

		//w.quit();
	}

}
