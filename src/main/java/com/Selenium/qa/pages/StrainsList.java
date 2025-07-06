package com.Selenium.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Selenium.qa.base.TestBase;

public class StrainsList extends TestBase{
	
	@FindBy(xpath ="//span[text()='New Strain']")
	WebElement newstrain;
	
	@FindBy(xpath ="//tr[@class='ui-widget-content jqgrow ui-row-ltr colorpickerblack a'][1]//td[@class='line-wrap']/a[1]")
	WebElement firstitem;
	
	@FindBy(xpath ="//button[@id ='editSaveAndBack']")
	WebElement savebtn;
	
	@FindBy(xpath ="//tr[@class='ui-widget-content jqgrow ui-row-ltr colorpickerblack a'][1]//input[@type='checkbox' and contains(@id, 'jqg_mouseline_table_')]")
	WebElement checkbox;
	
	@FindBy(xpath ="//span[@title ='Delete Mouseline']")
	WebElement deletebtn;
	
	

	public StrainsList() {
		PageFactory.initElements(driver, this);
	}
	
	public CreateNewStrain ClickNewStrain() {
		newstrain.click();
		
		return new CreateNewStrain();
		
	}
	
	public void SelectFirstItem() {
		firstitem.click();
	}
	public void EditAndSave() {
		savebtn.click();
	}
	public void selectStrainCheckbox() {
        if (!checkbox.isSelected()) {
        	checkbox.click();
        }
	}
	public void ClickDeleteBtn() {
		deletebtn.click();
	}
	
	 
	
	
}
