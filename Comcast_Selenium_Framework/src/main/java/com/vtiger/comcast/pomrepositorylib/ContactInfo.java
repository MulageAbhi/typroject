package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains the contact information
 * @author Admin
 *
 */
public class ContactInfo {

	public ContactInfo(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement conSucsMsg;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameInCon;
	
	public WebElement getConSucsMsg() {
		return conSucsMsg;
		
	}

	public WebElement getOrgNameInCon() {
		return orgNameInCon;
	}
	
}
