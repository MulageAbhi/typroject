package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains organization information
 * @author Admin
 *
 */
public class OrganizationsInfo {

	public OrganizationsInfo(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement sucsMsg;

	public WebElement getSucsMsg() {
		return sucsMsg;
	}
	
	@FindBy(id="mouseArea_Industry")
	private WebElement indstryMsg;

	public WebElement getIndstryMsg() {
		return indstryMsg;
	}
}
