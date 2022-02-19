package com.selenium.basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Assignment_Snapdeal {

	public static void main(String[] args) throws Exception {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		WebDriver w = new ChromeDriver();

		w.get("https://www.google.com/");
		w.findElement(By.name("q")).sendKeys("Snapdeal");
		Thread.sleep(2000);
		w.findElement(By.cssSelector("div.wM6W7d")).click();
		Thread.sleep(2000);
		w.findElement(By.linkText("Wikipedia")).click();

		w.findElement(By.name("search")).sendKeys("News");
		Thread.sleep(2000);

		w.findElement(By.id("searchButton")).click();

		w.findElement(By.linkText("View history")).click();
		Thread.sleep(2000);

	//	w.close();

	}

}
