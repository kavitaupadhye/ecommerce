package com.selenium.pageobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDeposit_PageObj extends TestBase{
	

	@FindBy(id = "loginform-username")
	public WebElement username_TextBox;

	@FindBy(id = "loginform-password")
	public WebElement password_TextBox;

	

	@FindBy(name = "login-button")
	public WebElement signin_Btn;

	

	
	public void callPageFactory_FixedDeposit() {

		PageFactory.initElements(w, this);

	}

}
