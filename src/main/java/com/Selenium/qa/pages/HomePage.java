package com.Selenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//p[text()='Enter your Colony Here']")
	WebElement entercolony;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public StrainsList EnterColonyHere(){
		entercolony.click();
		
		return new StrainsList();
		
	}
}
