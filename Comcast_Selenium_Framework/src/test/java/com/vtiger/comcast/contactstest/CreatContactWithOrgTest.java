package com.vtiger.comcast.contactstest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericLibrary.ExcelUtility;
import com.vtiger.comcast.genericLibrary.FileUtility;
import com.vtiger.comcast.genericLibrary.JavaUtility;
import com.vtiger.comcast.genericLibrary.WebDriverUtility;
import com.vtiger.comcast.pomrepositorylib.ContactInfo;
import com.vtiger.comcast.pomrepositorylib.ContactPage;
import com.vtiger.comcast.pomrepositorylib.CreatNewContacts;
import com.vtiger.comcast.pomrepositorylib.CreatNewOrganization;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;
import com.vtiger.comcast.pomrepositorylib.OrganizationsInfo;
import com.vtiger.comcast.pomrepositorylib.OrganizationsPage;

public class CreatContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		//create objects
		JavaUtility jLib=new JavaUtility();
		FileUtility fLib=new FileUtility();
		ExcelUtility exLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		//read common data
		String USERNAME = fLib.getDataFromPropertyFile("username");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		String URL = fLib.getDataFromPropertyFile("url");
		//String BROWSER = fLib.getDataFromPropertyFile("browser");
		String BROWSER = "firefox";
		
		int randomInt = jLib.getRandomNumber();
		
		//read test data
		String orgName = exLib.getDataFromExcel("Sheet1", 0,0) +randomInt ;
		String lastName=exLib.getDataFromExcel("Sheet1", 0, 1)+randomInt;
		//step1:launch the browser
		WebDriver driver =null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else
		{
			System.out.println("invalid browser");
		}
		
		wLib.waitTillPageLoad(driver);
		driver.get(URL);
		
		//step 2:login to app
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//step 3:navigate to org
		HomePage h=new HomePage(driver);
		h.getOrglnk().click();
				
		//step 4:navigate to craete org page
		OrganizationsPage org=new OrganizationsPage(driver);
		org.getCreateOrg().click();
			
		//step 5:creat org
		CreatNewOrganization newOrg=new CreatNewOrganization(driver);
		newOrg.createOrg(orgName);
		
		wLib.waitUntillElemntClick(h.getCont());
		//step 6:navigate to contact page
		h.getCont().click();
		
		//step 7:navigate to creat new contact page
		ContactPage c=new ContactPage(driver);
		c.getCrtcontct().click();
		
		//step 8:creat new contact with org name
		CreatNewContacts nc=new CreatNewContacts(driver);
		nc.creatContWithOrg(lastName, orgName);
		
		
		//step :verify the details withmandate information
		ContactInfo ci=new ContactInfo(driver);
		wLib.waitForElementVisible(driver, ci.getConSucsMsg());
		String actualmsg=ci.getOrgNameInCon().getText();
		if(actualmsg.contains(orgName)) {
			System.out.println("contact is created with org succesfully==>pass");
		}
		else {
			System.out.println("contact is not created with org succesfully==>fail");
		}
		h.logout();
	}

}
