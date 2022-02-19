package com.selenium.basictest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTestCase {

	public static void main(String[] args) {
		
	//	interfaceName instance = new implementClass(); 
		
	     
		// 2 parameter (which driver, path of driver)
		
		//Get current project path
		String projectPath=System.getProperty("user.dir");
		
		//Set driver property
		System.setProperty("webdriver.chrome.driver", projectPath+"\\BrowserDriver\\chromedriver.exe"); 
		
		//webdriver comipler to open chrome browser
		WebDriver w=new ChromeDriver();
		System.out.println("Blank browser opened"); 
		
		
		w.quit();

	}

}
