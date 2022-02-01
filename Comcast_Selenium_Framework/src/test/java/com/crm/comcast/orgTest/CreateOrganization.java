package com.crm.comcast.orgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganization {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		
FileInputStream fis=new FileInputStream("./data/commondata.property");
		
		Properties p=new Properties();
		p.load(fis);
		String a1 = p.getProperty("browser");
		String a2 = p.getProperty("url");
		String a3 = p.getProperty("username");
		String a4 = p.getProperty("password");
		
		Random r=new Random();
		int ran=r.nextInt(1000);
		FileInputStream fise=new FileInputStream("./data/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String orgName = wb.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue()+ran;
		System.out.println(orgName);
		
		WebDriver driver=null;
		if(a1.equalsIgnoreCase("FireFoxDriver")) {
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(a2);
		driver.findElement(By.name("user_name")).sendKeys(a3);
		driver.findElement(By.name("user_password")).sendKeys(a4);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String title = driver.findElement(By.className("dvHeaderText")).getText();
		System.out.println(title);
		if(title.contains(orgName)) {
			System.out.println("test case passed");
			
		}
		else
		{
			System.out.println("test case failed");
		}
			
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}

}
