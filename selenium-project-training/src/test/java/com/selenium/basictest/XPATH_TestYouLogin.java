package com.selenium.basictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATH_TestYouLogin {

	public static void main(String[] args) throws Exception {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		WebDriver w = new ChromeDriver();

		w.get("http://www.testyou.in/Login.aspx");

		w.findElement(By.xpath("/html/body/form/div[6]/div[1]/div/div[3]/div/div[2]/div[1]/div[2]/div[2]/div/input")).sendKeys("Selenium99");
		w.findElement(By.xpath("//*[@id=\"ctl00_CPHContainer_txtPassword\"]")).sendKeys("Selenium99");
		w.findElement(By.xpath("/html/body/form/div[6]/div[1]/div/div[3]/div/div[2]/div[1]/div[5]/div[1]/input")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"ctl00_headerTopStudent_lnkbtnSignout\"]")).click();

		w.close();
		System.out.println("Test case using xpath...Done");

	}

}
