package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPrprtyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		
		Properties p=new Properties();
		p.load(fis);
		String a1 = p.getProperty("browser");
		String a2 = p.getProperty("url");
		String a3 = p.getProperty("username");
		String a4 = p.getProperty("password");
		WebDriver driver=null;
		if(a1.equalsIgnoreCase("FireFoxDriver")) {
			driver=new FirefoxDriver();
		}
		driver.get(a2);
		driver.findElement(By.name("user_name")).sendKeys(a3);
		driver.findElement(By.name("user_password")).sendKeys(a4);
		driver.findElement(By.id("submitButton")).click();
	}

}
