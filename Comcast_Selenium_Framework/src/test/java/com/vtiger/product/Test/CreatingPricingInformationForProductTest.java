package com.vtiger.product.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class CreatingPricingInformationForProductTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
FileInputStream fis=new FileInputStream("./data/commondata.property");
		
		Properties p=new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String uname = p.getProperty("username");
		String pwd = p.getProperty("password");
		
		//finding suitable browser
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("FireFoxDriver")) {
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//opening the browser
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
	
		
		//clicking on product module
		driver.findElement(By.linkText("Products")).click();
		
driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		driver.findElement(By.name("productname")).sendKeys("Keyboard");
		driver.findElement(By.id("unit_price")).sendKeys("4760.00");
		driver.findElement(By.id("commissionrate")).sendKeys("30");

		//save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
				//log out
				Actions act=new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				

	}

}
