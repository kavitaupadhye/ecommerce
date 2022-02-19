package com.selenium.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	static WebDriver w;
	
	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
			w.manage().window().maximize();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

	}

	public void closeBrowser() {
		w.quit();
	}

	public void enterValueTextBox(WebElement we, String value) {

		we.clear();
		we.sendKeys(value);

	}

	public void clickButton(WebElement we) 
	{
		we.click();
	}

	

	public void waitInSec(int sec) throws Exception {
		Thread.sleep(sec * 1000);
	}

	public void openApplicationURL(String url) {

		w.get(url);
	}

	public String readPropertiesFile_Value(String key) throws Exception {

		String projectPath = System.getProperty("user.dir");
		String configFilePath = projectPath + "\\Config\\config.properties";
		FileInputStream fin = new FileInputStream(configFilePath);
		Properties p = new Properties();
		p.load(fin);

		String value = p.getProperty(key);

		fin.close();

		return value;
	}

	public static void takeScreenshot(String folder,String fileName) throws Exception {

		String projectPath = System.getProperty("user.dir");
		String sreenshotFilePath = projectPath + "\\Screenshot\\"+folder+"\\"+fileName+".png";

		TakesScreenshot ts = (TakesScreenshot) w;

		File f = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(f, new File(sreenshotFilePath));

	}


}
