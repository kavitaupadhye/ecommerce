package com.selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Blaze_PageObj extends TestBase{
	
	@FindBy(name = "fromPort")
	public WebElement dropDownfromPort;

	@FindBy(name = "toPort")
	public WebElement dropDowntoPort;

	@FindBy(xpath = "//input[@value='Find Flights']")
	public WebElement btnFindFlights;

	@FindBy(css = "input[value='Choose This Flight']")
	public WebElement btChooseThisFlight;

	

	public void exportPageObjectElement_Blaze() {

		PageFactory.initElements(w, this);
	}



}
