package com.Selenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium.qa.base.TestBase;

public class CreateNewStrain extends TestBase{
	
	@FindBy(id ="name")
	WebElement nameinput;
	
	@FindBy(xpath ="//input[@id='tailAge']")
	WebElement tailage;
	@FindBy(xpath ="//textarea[@id=\"comment\"]")
	WebElement commentinput;
	
	@FindBy(xpath ="//button[@id='editSaveAndBack']")
	WebElement button;

	@FindBy(xpath="//label[text() =\"Strain name is required\"]")
	WebElement errormsg;
	
	public CreateNewStrain(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void CreateANewStrain(String Name,String Comment) {
		nameinput.sendKeys(Name);
		commentinput.sendKeys(Comment);
		button.click();
	}
	

	public String CreateNewStrainError()
	{
		button.click();
		return errormsg.getText();
	}
	
	public void EditComment(String Comment) {
		commentinput.sendKeys(Comment);
	}
	
	//public String getStrainNameError() {
		
		//return errormsg.getText();
		
	//}
}
