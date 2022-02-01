package com.vtiger.comcast.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.comcast.genericLibrary.ExcelUtility;
import com.vtiger.comcast.genericLibrary.FileUtility;
import com.vtiger.comcast.genericLibrary.JavaUtility;
import com.vtiger.comcast.genericLibrary.WebDriverUtility;
import com.vtiger.comcast.pomrepositorylib.CreatNewOrganization;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;
import com.vtiger.comcast.pomrepositorylib.OrganizationsPage;
import com.vtiger.comcast.pomrepositorylib.OrganizationsInfo;

public class CreatOrgWithIndustryTest {

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
		String orgName = exLib.getDataFromExcel("Sheet1", 0,1) +randomInt ;
		String industry=exLib.getDataFromExcel("Sheet1", 0, 2);
		
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
		//step 2:login to app
		driver.get(URL);
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
		newOrg.crtOrgWithIndustry(orgName,industry);
		
		//step 6:verify
		OrganizationsInfo info=new OrganizationsInfo(driver);
		wLib.waitForElementVisible(driver, info.getSucsMsg());
		String actualmsg=info.getSucsMsg().getText();
		if(actualmsg.contains(orgName)) {
			System.out.println("organization is created succesfully==>pass");
		}
		else {
			System.out.println("organization is not created succesfully==>fail");
		}
			
		//step 6:logout
		h.logout();
		
        //cose the browser
        driver.quit();
	}
	}


