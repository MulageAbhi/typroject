package com.vtiger.comcast.genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mysql.jdbc.Driver;
import com.vtiger.comcast.pomrepositorylib.HomePage;
import com.vtiger.comcast.pomrepositorylib.LoginPage;

/**
 * This is base class which contains common functionalities
 * @author Admin
 *
 */
public class BaseAnnotationClass {

	//create objects
	public JavaUtility jLib=new JavaUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility exLib=new ExcelUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver =null;
	Connection conn=null;
	public static WebDriver sDriver=null;
	
	@BeforeSuite(groups={"RegressionTest","SmokeTest"})
	public void configBS() throws Throwable {
		/*
		Driver driverRef=new Driver();
		//step:1  load/register mysql the database
		
		DriverManager.registerDriver(driverRef);
		//step 2: connection to db
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		 */
		System.out.println("========connection to DB==========");
		
	}
	
	//@Parameters("browser")
	@BeforeClass(groups={"RegressionTest","SmokeTest"})
	public void configBC(/*String BROWSER*/) throws Throwable {
	
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		//String BROWSER="firefox";
		//step1:launch the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
		driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else
		{
			System.out.println("invalid browser");
		}
		String URL = fLib.getDataFromPropertyFile("url");
		driver.manage().window().maximize();
		wLib.waitTillPageLoad(driver);
		driver.get(URL);
		sDriver=driver;
		
		System.out.println("=========open the browser==========");
	}
	@BeforeMethod(groups={"RegressionTest","SmokeTest"})
	public void configBM() throws Throwable {
		//step 2:login to app
		//read common data
		String USERNAME = fLib.getDataFromPropertyFile("username");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("==============Login================");
	}
	@AfterMethod(groups={"RegressionTest","SmokeTest"})
	public void configAM() {
		//step 6:logout
		HomePage h=new HomePage(driver);
		h.logout();
		System.out.println("============Logout=================");
	}
	
	@AfterClass(groups={"RegressionTest","SmokeTest"})
	public void configAC() {
		driver.quit();
		System.out.println("========close the browser===========");
	}
	
	@AfterSuite(groups={"RegressionTest","SmokeTest"})
	public void configAS() throws Throwable {
	
		//conn.close();
		System.out.println("============connection to DB closed===============");
		
	}
}
