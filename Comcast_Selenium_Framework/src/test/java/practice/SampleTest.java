package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=new FirefoxDriver(); 
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	}

}
