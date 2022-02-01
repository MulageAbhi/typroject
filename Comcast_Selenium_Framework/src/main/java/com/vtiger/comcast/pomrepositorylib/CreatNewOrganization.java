package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * This class is used to create new organization
 * @author Admin
 *
 */
public class CreatNewOrganization {

	public CreatNewOrganization(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="accounttype")
	private WebElement acttype;
	
	public WebElement getIndustry() {
		return industry;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getActtype() {
		return acttype;
	}

	/**
	 * This methodis used to create new organization
	 * @param orgName
	 */
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
		/**
		 * This method is used to create new organiztionwith industry type
		 * @param orgName
		 */
		public void crtOrgWithIndustry(String orgName,String indus) {
			orgNameEdt.sendKeys(orgName);
			Select s=new Select(industry);
			s.selectByValue(indus);
			
			Select s1=new Select(acttype);
			//s1.selectByIndex(8);
			s1.selectByIndex(3);
			saveBtn.click();
	}

		
}
