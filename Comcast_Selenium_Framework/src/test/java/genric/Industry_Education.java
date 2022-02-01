package genric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericLibrary.ExcelUtility;
import com.vtiger.comcast.genericLibrary.FileUtility;
import com.vtiger.comcast.genericLibrary.JavaUtility;
import com.vtiger.comcast.genericLibrary.WebDriverUtility;

public class Industry_Education {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		int randomInt = jLib.getRandomNumber();
		
		String USERNAME = fLib.getDataFromPropertyFile("username");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		String URL = fLib.getDataFromPropertyFile("url");
		String BROWSER = fLib.getDataFromPropertyFile("browser");
				
		String orgName = eLib.getDataFromExcel("Sheet1", 0,0) + randomInt;
		String lname=eLib.getDataFromExcel("sheet1", 0,1)+randomInt;
		
		WebDriver driver =null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
		}
		wLib.waitTillPageLoad(driver);
        driver.get(URL);
     
        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
        
		driver.findElement(By.linkText("Organizations")).click();
	
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement ind = driver.findElement(By.name("industry"));
		wLib.toHandleselect(ind, 8);
		
		WebElement name = driver.findElement(By.name("accounttype"));
		wLib.toHandleselect(name, 3);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(4000);
		 driver.findElement(By.linkText("Contacts")).click();
		//contacts.click();
	//	wLib.waitUntillElemntClick(contacts);
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lname);
		driver.findElement(By.xpath("//input[@name='account_name']/../../td[2]/img")).click();
		String partial = "Accounts";
		wLib.switchToWindow(driver,partial );
		Thread.sleep(3000);
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		String actual = "Contacts";
		wLib.switchToWindow(driver, actual);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, signout);
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
