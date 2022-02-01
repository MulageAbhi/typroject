package genric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericLibrary.ExcelUtility;
import com.vtiger.comcast.genericLibrary.FileUtility;
import com.vtiger.comcast.genericLibrary.JavaUtility;
import com.vtiger.comcast.genericLibrary.WebDriverUtility;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {
		
		  /*Object Creation for Lib*/
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			
			int randomInt = jLib.getRandomNumber();
			
			/*common Data*/
			String USERNAME = fLib.getDataFromPropertyFile("username");
			String PASSWORD = fLib.getDataFromPropertyFile("password");
			String URL = fLib.getDataFromPropertyFile("url");
			String BROWSER = fLib.getDataFromPropertyFile("browser");
			
			/*test script Data*/
			String orgName = eLib.getDataFromExcel("Sheet1", 0,0) + randomInt;
			
			/* Navigate to app*/
			WebDriver driver =null;
			if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
			}
			wLib.waitTillPageLoad(driver);
	        driver.get(URL);
	        
	        /* step 1 : login */
	        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
	        
	        /*step 2 : navigate to organization*/
			driver.findElement(By.linkText("Organizations")).click();
			
			
	        
	        /*step 3 : navigate to "create new organization"page by click on "+" image */
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
	        /*step 4 : create organization*/
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	        
	       /*step 5 : verify the successful msg with org name*/
	       
			String title = driver.findElement(By.className("dvHeaderText")).getText();
			System.out.println(title);
			if(title.contains(orgName)) {
				System.out.println("organization created succcesfully");
				
			}
			else
			{
				System.out.println(" organization not created");
			}
				
	       /*step 6 : logout*/
			WebElement wel = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        wLib.mouseHover(driver, wel);
	        driver.findElement(By.linkText("Sign Out")).click();
		}

	}


