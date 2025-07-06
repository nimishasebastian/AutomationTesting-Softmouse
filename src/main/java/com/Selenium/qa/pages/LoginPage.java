package com.Selenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page Factory -OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id ="secureLogin")
	WebElement Loginbtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}


public HomePage login(String em, String psd) {
	username.sendKeys(em);
	password.sendKeys(psd);
	Loginbtn.click();
	return new HomePage();
	
}
}
