package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericLibrary.WebDriverUtility;
/**
 * This class contains different modules link present in home page
 * @author Admin
 *
 */
public class HomePage extends WebDriverUtility{

		WebDriver driver;//global var
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements( driver,this);
		}
		@FindBy(linkText="Organizations")
		private WebElement orglnk;
	
		@FindBy(linkText="Contacts")
		private WebElement cont;
		
		
		@FindBy(linkText="Products")
		private WebElement prductlnk;

		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminstationimg;
		
		@FindBy(linkText="Sign Out")
		private WebElement logoutlnk;
		
		public WebDriver getDriver() {
			return driver;
		}
		

		public WebElement getCont() {
			return cont;
		}


		public WebElement getOrglnk() {
			return orglnk;
		}

		public WebElement getPrductlnk() {
			return prductlnk;
		}

		public WebElement getAdminstationimg() {
			return adminstationimg;
		}

		public WebElement getLogoutlnk() {
			return logoutlnk;
		}
		
		/**
		 * This method is used to logout
		 * @throws InterruptedException 
		 */
		public void logout() {
			mouseHover(driver, adminstationimg);
			//Actions a=new Actions(driver);
		//	a.moveToElement(adminstationimg).perform();
			
			logoutlnk.click();
		}

	}


