package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class navigate to creat new organization link
 * @author Admin
 *
 */
public class OrganizationsPage {

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrg;

	public WebElement getCreateOrg() {
		return createOrg;
	}
	
	@FindBy(name="search_text")
	private WebElement srechEdt;
	
	@FindBy(name="search")
	private WebElement srcBtn;

	public WebElement getSrechEdt() {
		return srechEdt;
	}

	public WebElement getSrcBtn() {
		return srcBtn;
	}
}
