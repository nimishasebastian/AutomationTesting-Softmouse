package com.Selenium.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class StrainsListTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homepage;
	StrainsList strainslist;
	CreateNewStrain createnewstrain;
	TestUtil testutil;
	String sheetName ="EditStrain";
	
	public StrainsListTest() {
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
	
	@Test(priority =1,dataProvider= "getTestData") // Test Case 4 - Edit Strain
	public void testEditStrain(String Comment) {
		 strainslist= homepage.EnterColonyHere();
		switchToNewWindow();
		strainslist.SelectFirstItem();
		createnewstrain.EditComment(Comment);
		strainslist.EditAndSave();
		strainslist.SelectFirstItem();
	}
	
	@Test(priority =2) // Test Case 5 - Delete Strain
	public void TestDeleteStrain() {
		 strainslist= homepage.EnterColonyHere();
		switchToNewWindow();
		strainslist.selectStrainCheckbox();
		strainslist.ClickDeleteBtn();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		    alert.accept();
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	

}
