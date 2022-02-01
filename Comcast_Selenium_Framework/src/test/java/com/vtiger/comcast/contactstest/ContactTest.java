package com.vtiger.comcast.contactstest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibrary.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositorylib.ContactInfo;
import com.vtiger.comcast.pomrepositorylib.ContactPage;
import com.vtiger.comcast.pomrepositorylib.CreatNewContacts;
import com.vtiger.comcast.pomrepositorylib.CreatNewOrganization;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.OrganizationsInfo;
import com.vtiger.comcast.pomrepositorylib.OrganizationsPage;

public class ContactTest extends BaseAnnotationClass {
	
	@Test(groups="SmokeTest")
	public void creatContactTest() throws Throwable {
		
		int randomInt = jLib.getRandomNumber();
		
		//read test data
		String orgName = exLib.getDataFromExcel("Sheet1", 0,0) +randomInt ;
		String lastName=exLib.getDataFromExcel("Sheet1", 0, 1)+randomInt;
		
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
		Assert.assertTrue(actualmsg.contains(lastName));
		System.out.println("contact is created succesfully==>PASS");
				
	}
	@Test(groups="RegressionTest")
	public void creatContactWithOrgTest() throws Throwable {
int randomInt = jLib.getRandomNumber();
		
		//read test data
		String orgName = exLib.getDataFromExcel("Sheet1", 0,0) +randomInt ;
		String lastName=exLib.getDataFromExcel("Sheet1", 0, 1)+randomInt;
		
		//step 3:navigate to org
		HomePage h=new HomePage(driver);
		h.getOrglnk().click();
				
		//step 4:navigate to craete org page
		OrganizationsPage org=new OrganizationsPage(driver);
		org.getCreateOrg().click();
			
		//step 5:creat org
		CreatNewOrganization newOrg=new CreatNewOrganization(driver);
		newOrg.createOrg(orgName);
		
		OrganizationsInfo oi=new OrganizationsInfo(driver);
		
		Assert.assertTrue(oi.getSucsMsg().getText().contains(orgName));
		
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
		String actualmsg1=ci.getConSucsMsg().getText();
		Assert.assertTrue(actualmsg1.contains(lastName));
		System.out.println("contact is created succesfully==>PASS");
		String actualmsg=ci.getOrgNameInCon().getText();
		
		Assert.assertTrue(actualmsg.contains(orgName));
		System.out.println("contact is created with organization succesfully==>PASS");
	}

}
