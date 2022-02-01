package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericLibrary.WebDriverUtility;
/**
 * This class used to create new contact
 * @author Admin
 *
 */
public class CreatNewContacts extends WebDriverUtility{

	WebDriver driver;
	public CreatNewContacts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lstName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='account_name']/../img")
	private WebElement newOrg;

	public WebElement getLstName() {
		return lstName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getNewOrg() {
		return newOrg;
	}
	/**
	 * This method is used to create new contact
	 * @param lastname
	 */
	public void creatCont(String lastname) {
		lstName.sendKeys(lastname);
		saveBtn.click();
		
	}
	/**
	 * This metod is used to create new contact with organization
	 * @param lastname
	 * @param orgName
	 */
	public void creatContWithOrg(String lastname,String orgName) {
		lstName.sendKeys(lastname);
		newOrg.click();
		switchToWindow(driver,"Accounts&action" );
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getSrechEdt().sendKeys(orgName);
		op.getSrcBtn().click();;
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	}
}
