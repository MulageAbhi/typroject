package com.vtiger.product.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreatingProductWithProductInformationTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		//Reading the data from property file
		//navigational steps
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
		//synchronization
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//opening the browser
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
	
		
		//clicking on product module
		driver.findElement(By.linkText("Products")).click();
		
		//creating new product
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//inserting details
		
		//inserting product name
		driver.findElement(By.name("productname")).sendKeys("Keyboard");
		
		//part no
		driver.findElement(By.id("productcode")).sendKeys("12");
		//vender part no
		
		//sales start date)
		driver.findElement(By.id("jscal_field_sales_start_date")).sendKeys("2018-05-09");
	/*	driver.findElement(By.id("jscal_trigger_sales_start_date")).click();
		//year
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		
		//month
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		
		//date
		driver.findElement(By.xpath("//td[text()='8']")).click();
		*/
		//sales end date
		
		//Thread.sleep(3000);
		driver.findElement(By.id("jscal_field_sales_end_date")).sendKeys("2018-05-30");
		/*driver.findElement(By.id("jscal_trigger_sales_end_date")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='«']")));
		
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		
		driver.findElement(By.xpath("//td[text()='30']")).click();
		
		*/
		//support start date
		driver.findElement(By.id("jscal_field_start_date")).sendKeys("2018-05-09");
		/*
		driver.findElement(By.id("jscal_trigger_start_date")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		driver.findElement(By.xpath("//td[text()='›']")).click();
		
		driver.findElement(By.xpath("//td[text()='9']")).click();
		*/
		//Thread.sleep(5000);
		//support end date
		driver.findElement(By.id("jscal_field_expiry_date")).sendKeys("2018-10-12");
		/*
		driver.findElement(By.id("jscal_trigger_expiry_date")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		driver.findElement(By.xpath("//td[text()='«']")).click();
		
		driver.findElement(By.xpath("//td[text()='‹']")).click();
		driver.findElement(By.xpath("//td[text()='‹']")).click();
		driver.findElement(By.xpath("//td[text()='‹']")).click();
		
		driver.findElement(By.xpath("//td[text()='12']")).click();
		*/
		
		//product category
		WebElement cat = driver.findElement(By.xpath("//select[@name='productcategory']"));
		Select s=new Select(cat);
		s.selectByIndex(1);
		
		//manf
		WebElement man = driver.findElement(By.xpath("//select[@name='manufacturer']"));
		Select s1=new Select(man);
		s1.selectByIndex(2);
		
		driver.findElement(By.id("vendor_part_no")).sendKeys("12");
		
		//website
		driver.findElement(By.name("website")).sendKeys("www.Nokia.com");
		
		//mfr part no
		driver.findElement(By.id("mfr_part_no")).sendKeys("12");
		
		//serial no
		driver.findElement(By.id("serial_no")).sendKeys("12");
		
		//product sheet
		driver.findElement(By.id("productsheet")).sendKeys("Product Details");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//log out
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		 
	}

}
