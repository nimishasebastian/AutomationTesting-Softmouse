package com.Selenium.qa.testcases;

import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Selenium.qa.base.TestBase;
import com.Selenium.qa.pages.CreateNewStrain;
import com.Selenium.qa.pages.HomePage;
import com.Selenium.qa.pages.LoginPage;
import com.Selenium.qa.pages.StrainsList;
import com.Selenium.qa.util.TestUtil;

public class CreateNewStrainTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	StrainsList strainslist;
	CreateNewStrain createnewstrain;
	TestUtil testutil;
	String sheetName ="CreateNewStrain";
	
	public CreateNewStrainTest() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		switchToNewWindow();
		 loginPage = new LoginPage() ;	
		 testutil = new TestUtil();
		 strainslist =new StrainsList();
		 createnewstrain =new CreateNewStrain();
		 homepage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		 
		
	}
	@DataProvider
	public Object[][] getTestData() {
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority =1,dataProvider= "getTestData")  // Test Case 2 - Create a New Strain
	public void testCreateANewStrain(String Name,String Comment) {
		 strainslist= homepage.EnterColonyHere();
		switchToNewWindow();
		strainslist.ClickNewStrain();
		createnewstrain.CreateANewStrain(Name,Comment);	
		
	}
	

	@Test(priority =2)  // Test Case 3 - Negative Test for Create new Strain
	public void NegativetestCreateANewStrain() {
		strainslist= homepage.EnterColonyHere();
		switchToNewWindow();
		strainslist.ClickNewStrain();
		createnewstrain.CreateNewStrainError();
		String actualError = createnewstrain.CreateNewStrainError();
        String expectedError = "Strain name is required"; 

        Assert.assertEquals(actualError, expectedError, "Error message does not match.");
		
		
	}

	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	

	

}
