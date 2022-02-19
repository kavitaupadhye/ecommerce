package com.selenium.keyworddriven;

import org.testng.annotations.Test;

import com.selenium.pageobject.FixedDeposit_PageObj;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.report.ListenerCode.class)

public class FixedDeposit_Test {

	FixedDeposit_PageObj fd;

	@BeforeTest
	public void beforeTest() throws Exception {

		fd = new FixedDeposit_PageObj();
		
		fd.openBrowser(fd.readPropertiesFile_Value("browser"));
		
		
		fd.callPageFactory_FixedDeposit();
	}

	@Test(priority = 0,description = "Fixed depost for 10000")
	public void FixedDeposit_10000() throws Exception {

		fd.openApplicationURL(fd.readPropertiesFile_Value("url"));
		
		fd.enterValueTextBox(fd. username_TextBox, "admin");
		fd.enterValueTextBox(fd.password_TextBox, "Admin@1111");
		

		fd.clickButton(fd.signin_Btn);

		fd.waitInSec(4);

	}
	
	
	



	@AfterTest
	public void afterTest() {

		//fd.closeBrowser();
	}

}
