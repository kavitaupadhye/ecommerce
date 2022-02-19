package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.selenium.pageobject.Calculator_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class Calculator_Test {
	
	Calculator_PageObj c=new Calculator_PageObj();

	@BeforeTest
	public void preCondition() throws Exception {
		
		c.openBrowser(c.readPropertiesFile_Value("browser"));
		c.callPageFactory_Calculator_PageObj();
		
	}

	@Test(priority = 0, description = "verify addition operation",groups="Calculator_Test")
	public void addOperation() throws Exception {
		
		c.openApplicationURL(c.readPropertiesFile_Value("calculator_url"));
		
		c.enterValueTextBox(c.firstInputNumber_TextBox,"10");
		c.selectFromDropDown(c.operator_DropDown, "+");
		c.enterValueTextBox(c.secondInputNumber_TextBox, "9");
		c.clickButton(c.goBtn);
		c.waitInSec(3);
		
	   
	    
		
		
	}

	@Test(priority = 1, description = "verify subtraction operation",groups="Calculator_Test")
	public void subOperation() throws Exception {
		
		c.enterValueTextBox(c.firstInputNumber_TextBox,"8");
		c.selectFromDropDown(c.operator_DropDown, "-");
		c.enterValueTextBox(c.secondInputNumber_TextBox, "2");
		c.clickButton(c.goBtn);
		c.waitInSec(3);
		
	
	}

	@Test(priority = 2, description = "verify division operation",groups="Calculator_Test")
	public void divOperation() throws Exception {
		
		c.enterValueTextBox(c.firstInputNumber_TextBox,"4");
		c.selectFromDropDown(c.operator_DropDown, "/");
		c.enterValueTextBox(c.secondInputNumber_TextBox, "2");
		c.clickButton(c.goBtn);
		c.waitInSec(3);
		
	
	}

	@Test(priority = 3, description = "verify multiplication operation",groups="Calculator_Test")
	public void mulOperation() throws Exception {
		
		c.enterValueTextBox(c.firstInputNumber_TextBox,"8");
		c.selectFromDropDown(c.operator_DropDown, "*");
		c.enterValueTextBox(c.secondInputNumber_TextBox, "8");
		c.clickButton(c.goBtn);
		c.waitInSec(3);
		
	
	}

	@AfterTest
	public void postCondition() {
	
		c.closeBrowser();
	}

}
