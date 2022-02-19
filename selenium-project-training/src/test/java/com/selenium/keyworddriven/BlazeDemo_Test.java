package com.selenium.keyworddriven;

import org.testng.annotations.*;

import com.selenium.pageobject.Blaze_PageObj;

public class BlazeDemo_Test {
	Blaze_PageObj b;

	@BeforeTest
	public void beforeTest() throws Exception {
		b = new Blaze_PageObj();
		b.openBrowser(b.readPropertiesFile_Value("browser"));
		b.exportPageObjectElement_Blaze();
	}

	@Test(priority = 0, description = "Test to select flight from and to functioanlity",groups="Blaze")
	public void Blazedemo_flight() throws Exception {

		b.openApplicationURL(b.readPropertiesFile_Value("url_blaze"));

		b.selectFromDropDown(b.dropDownfromPort, "Boston");
		b.selectFromDropDown(b.dropDowntoPort, "London");
	}

	@Test(priority = 1, description = "Test to verify flight from and to - detail functioanlity",groups="Blaze")
	public void Blazedemo_flight_Info() throws Exception {

		b.clickButton(b.btnFindFlights);
		b.waitInSec(2);

	}

	@Test(priority = 2, description = "Test to verify flight price and tax with user info functioanlity",groups="Blaze")
	public void Blazedemo_userInfo() throws Exception {

		b.clickButton(b.btChooseThisFlight);
		b.waitInSec(2);
	//	Assert.assertEquals(actual, expected);

	}

	@AfterTest
	public void afterTest() {
		b.closeBrowser();
	}
}


