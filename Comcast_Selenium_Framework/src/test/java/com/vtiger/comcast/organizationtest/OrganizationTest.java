package com.vtiger.comcast.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibrary.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositorylib.CreatNewOrganization;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.OrganizationsInfo;
import com.vtiger.comcast.pomrepositorylib.OrganizationsPage;

public class OrganizationTest extends BaseAnnotationClass {
	
	@Test(groups="SmokeTest")
	public void CreateOrganizationTest() throws Throwable{
		
		int randomInt = jLib.getRandomNumber();
		//read test data
		String orgName = exLib.getDataFromExcel("Sheet1", 0,1) +randomInt ;
		
		//step 3:navigate to org
		HomePage h=new HomePage(driver);
		h.getOrglnk().click();
		
		//step 4:navigate to craete org page
		OrganizationsPage org=new OrganizationsPage(driver);
		org.getCreateOrg().click();
	
		//step 5:creat org
		CreatNewOrganization newOrg=new CreatNewOrganization(driver);
		newOrg.createOrg(orgName);
		
		//step 6:verify
		OrganizationsInfo info=new OrganizationsInfo(driver);
		wLib.waitForElementVisible(driver, info.getSucsMsg());
		String actualmsg=info.getSucsMsg().getText();
		Assert.assertTrue(actualmsg.contains(orgName));		
		System.out.println("oganization is created succesfully==>PASS");
	}
	@Test(groups="RegressionTest")
	public void CreatOrgWithIndustryTest() throws Throwable {
		
		int randomInt = jLib.getRandomNumber();
		
		//read test data
		String orgName = exLib.getDataFromExcel("Sheet1", 0,1) +randomInt ;
		String industry=exLib.getDataFromExcel("Sheet1", 0, 2);
		
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
		
		Assert.assertTrue(actualmsg.contains(orgName));	
		System.out.println("oganization is created succesfully==>PASS");
		String indms=info.getIndstryMsg().getText();
		
		Assert.assertEquals(indms,industry);
		System.out.println("oganization is created with industry succesfully==>PASS");
		
	}
}
