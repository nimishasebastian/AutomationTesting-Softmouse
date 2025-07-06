package com.Selenium.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Selenium.qa.base.TestBase;
import com.Selenium.qa.pages.HomePage;
import com.Selenium.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginPage = new LoginPage() ;		
		
	}
	
	@Test // Test Case 1 : Test Login Page
	public void LoginPagetest() {
		homepage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
