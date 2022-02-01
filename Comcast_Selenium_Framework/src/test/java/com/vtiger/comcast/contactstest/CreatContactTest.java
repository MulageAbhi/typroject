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
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;

public class CreatContactTest {

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
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		
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
		
		//step 2:navigate to contact page
		HomePage h=new HomePage(driver);
		h.getCont().click();
		
		//step 3:navigate to creat new contact page
		ContactPage c=new ContactPage(driver);
		c.getCrtcontct().click();
		
		//step 4:creat contact
		CreatNewContacts nc=new CreatNewContacts(driver);
		nc.creatCont(lastName);
		
		//step 5:verify the details
		ContactInfo ci=new ContactInfo(driver);
		wLib.waitForElementVisible(driver, ci.getConSucsMsg());
		String actualmsg=ci.getConSucsMsg().getText();
		if(actualmsg.contains(lastName)) {
			System.out.println("contact is created succesfully==>pass");
		}
		else {
			System.out.println("contact is not created succesfully==>fail");
		}
		
		//step 6:logout
		h.logout();
		
		driver.close();
	}

}
