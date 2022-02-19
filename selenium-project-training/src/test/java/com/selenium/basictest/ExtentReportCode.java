package com.selenium.basictest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ExtentReportCode {
	
	WebDriver w;
	
	ExtentHtmlReporter extentHtmlReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	@BeforeTest
	public void beforeTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\BrowserDriver\\chromedriver.exe");
		 w = new ChromeDriver();
		 
		 extentHtmlReporter=new ExtentHtmlReporter(projectPath+"\\ExtentReport.html");
		 extentHtmlReporter.config().setDocumentTitle("Regression Report");
		 extentHtmlReporter.config().setReportName("TestYou Login Test");
		 
		 extentReports=new ExtentReports();
		 extentReports.attachReporter(extentHtmlReporter);
		 extentReports.setSystemInfo("Selenium", "3.141.59");
		 extentReports.setSystemInfo("Java", "8");
		 extentReports.setSystemInfo("TestNG", "7.4.0");
	}

	@Test
	public void login_Selenium99() throws Exception {
		
		extentTest=extentReports.createTest("login_Selenium99");
		
		w.get("http://www.testyou.in/Login.aspx");

		w.findElement(By.id("ctl00_CPHContainer_txtUserLogin")).sendKeys("Selenium99");
		w.findElement(By.name("ctl00$CPHContainer$txtPassword")).sendKeys("Selenium99");
		w.findElement(By.name("ctl00$CPHContainer$btnLoginn")).click();
		Thread.sleep(2000);
		w.findElement(By.cssSelector("a.signout")).click();
	}

	@AfterMethod
	public void updateReport(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getMethod().getMethodName());
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getMethod().getMethodName());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(Status.SKIP, result.getMethod().getMethodName());
		}
		
		extentReports.flush(); // view the report in project folder
	}
	
	@AfterTest
	public void afterTest() {
		
		w.close();
	}

}
