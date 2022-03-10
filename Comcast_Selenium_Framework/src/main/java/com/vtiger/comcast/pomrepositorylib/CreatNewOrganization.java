package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.genericLibrary.WebDriverUtility;
/**
 * This class is used to create new organization
 * @author Admin
 *
 */
public class CreatNewOrganization {

	WebDriver driver=null;
	public CreatNewOrganization(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="accounttype")
	private WebElement acttype;
	
	@FindBy(name="account_name")
	private WebElement memberof;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement addmember;
	
	@FindBy(xpath = "//input[@src='themes/images/clear_field.gif']")
	private WebElement clearmember;
	
	@FindBy(id="search_txt")
	private WebElement serchmember;
	
	
	
	public WebElement getSerchmember() {
		return serchmember;
	}

	public WebElement getMemberof() {
		return memberof;
	}

	public WebElement getAddmember() {
		return addmember;
	}

	public WebElement getClearmember() {
		return clearmember;
	}

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

		/**
		 * This method is used to create org with type
		 * @param name
		 * @param typ
		 */
		public void creatOrgWithType(String name,String typ) {
			orgNameEdt.sendKeys(name);
			Select s1=new Select(acttype);
			//s1.selectByIndex(8);
			s1.selectByVisibleText(typ);
			saveBtn.click();
			
		}
		
		@FindBy(xpath = "//a[text()='vtigerCRM Inc']")
		private WebElement mem;
		/**
		 * This method will create org with member
		 * @param name
		 * @throws Throwable 
		 */
		public void createOrgWithMember(String name) throws Throwable {
			//getMemberof().click();
			orgNameEdt.sendKeys(name);
			getAddmember().click();
			WebDriverUtility wlib=new WebDriverUtility();
			wlib.switchToWindow(driver,"Accounts&action=Popup&popuptype");
		//	getSerchmember().sendKeys(name);
			mem.click();
			wlib.acceptAlertPopUp(driver);
			Thread.sleep(3000);
			wlib.switchToWindow(driver,"Accounts&action=EditView");
			saveBtn.click();
		}
		
		public void createOrgWithMemberAndClearMemberField(String name) throws InterruptedException {
			
			orgNameEdt.sendKeys(name);
			getAddmember().click();
			WebDriverUtility wlib=new WebDriverUtility();
			wlib.switchToWindow(driver,"Accounts&action=Popup&popuptype");
		//	getSerchmember().sendKeys(name);
			mem.click();
			wlib.acceptAlertPopUp(driver);
			Thread.sleep(3000);
			wlib.switchToWindow(driver,"Accounts&action=EditView");
			//getMemberof().click();
			//getMemberof().clear();
			getClearmember().click();
			saveBtn.click();
		}
}
