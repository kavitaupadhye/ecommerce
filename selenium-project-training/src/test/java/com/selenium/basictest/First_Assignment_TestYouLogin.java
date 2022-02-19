package com.selenium.basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Assignment_TestYouLogin {

	public static void main(String[] args) throws Exception {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		WebDriver w = new ChromeDriver();

		w.get("http://www.testyou.in/Login.aspx");

		w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");
		w.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys("Selenium99");
		w.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();
		Thread.sleep(2000);
		w.findElement(By.cssSelector("a.signout")).click();

		w.close();

	}

}
