package com.selenium.basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_CSS_LinkText {

	public static void main(String[] args)throws Exception {

		 String projectPath=System.getProperty("user.dir");		
			System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe"); 
			WebDriver w=new ChromeDriver();
			
			w.get("https://opensource-demo.orangehrmlive.com/");
			
			w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
			
			w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");
			
			w.findElement(By.cssSelector("input.button")).click();
			
			Thread.sleep(2000);
			
			w.findElement(By.id("welcome")).click();
			Thread.sleep(2000);
			
			w.findElement(By.linkText("Logout")).click();
			
			
			Thread.sleep(2000);
			w.quit();

	}

}
