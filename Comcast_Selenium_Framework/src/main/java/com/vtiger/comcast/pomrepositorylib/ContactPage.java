package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains create conatct link
 * @author Admin
 *
 */
public class ContactPage {
	public ContactPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement crtcontct;

	public WebElement getCrtcontct() {
		return crtcontct;
	}

}
