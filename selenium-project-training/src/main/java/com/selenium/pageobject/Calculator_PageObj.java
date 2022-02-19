package com.selenium.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Calculator_PageObj extends TestBase{
	
	@FindBy(css="input[ng-model='first'")
	public WebElement firstInputNumber_TextBox;
	
	@FindBy(css="input[ng-model='second'")
	public WebElement secondInputNumber_TextBox;
	

	@FindBy(css="select[ng-model='operator'")
	public WebElement operator_DropDown;
	
	
	@FindBy(id="gobutton")
	public WebElement goBtn;
	
	
	@FindBy(css="h2.ng-binding")
	public WebElement getOutputValue;
	
	
	public void callPageFactory_Calculator_PageObj() {
		PageFactory.initElements(w, this);
	}
	
	
	
	
}
