package com.vtiger.comcast.genericLibrary;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains the generic methods specific to WebDriver
 * @author Admin
 *
 */
public class WebDriverUtility {

	/**
	 * This generic method will wait for 10 seconds to load the page
	 * @param driver
	 */
	  public void waitTillPageLoad(WebDriver driver)
	   {
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   
	   }
	  
	  /**
	   * This metod will wait for 20 seconds to element to be visible
	   * @param driver
	   * @param element
	   */
	  public void waitForElementVisible(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOf(element));
	   }
	  
	  /**
	   * This method will wait for element to be clickable
	   * @param element
	   * @throws InterruptedException
	   */
	   public void waitUntillElemntClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		     try {
		   	       element.click();
		    	   break;
		    	   }
		     catch(Throwable e){
		    	 	Thread.sleep(500);
		    	 	count++;
		    	   }
	       }
	   }
	   
	   /**
	    * This method is used to handle the drop-down using visible text
	    * @param element
	    * @param option
	    */
	   public void toHandleselect(WebElement element, String option)
	   {
		   Select select=new Select(element);
		   select.selectByVisibleText(option);
		   
	   }
	   
	   /**
	    * This method is used to handle drop-down using index
	    * @param element
	    * @param index
	    */
	   public void toHandleselect(WebElement element, int index)
	   {
		   Select select=new Select(element);
		   select.selectByIndex(index);   
	   }
	   
	   /**
	    * This method is used to handle the drop-down using visible text
	    * @param text
	    * @param element
	    */
	   public void toHandleselect(String text,WebElement element)
	   {
		   Select select=new Select(element);
		   select.selectByVisibleText(text);;   
	   }
	   
	   /**
	    * This method is used to perform mouse hover action
	    * @param driver
	    * @param element
	    */
	   public void mouseHover(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();		   
	   }
	   
	   /**
	    * This method is used right-click on the element
	    * @param driver
	    * @param element
	    */
	   public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.contextClick(element).perform();
	   }
	   
	   /**
	    * This method is used to perform double-click on the element
	    * @param driver
	    * @param element
	    */
	   public void doubleClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.doubleClick(element).perform();
	   }
	   
	   /**
	    * This method is used to perform the drag and drop operation webelements
	    * @param driver
	    * @param src
	    * @param dest
	    */
	   public void dragANDDrop(WebDriver driver,WebElement src,WebElement dest)
	   {
		   Actions act = new Actions(driver);
		   act.dragAndDrop(src, dest).perform();
	   }
	   
	   /**
	    * This method is used to switch from one window to another
	    * @param driver
	    * @param partialWinTitle
	    */
	   public void switchToWindow(WebDriver driver,String partialWinTitle)
	   {
		   Set<String> win = driver.getWindowHandles();
		   Iterator<String> it = win.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }  
		   }
	   }
	   
	   /**
	    * This method will accept the Alert pop-up
	    * @param driver
	    */
	   public void acceptAlertPopUp(WebDriver driver)
	   {
		   driver.switchTo().alert().accept();
	   }
	   
	   /**
	    * This method will dismiss the Alert pop-up
	    * @param driver
	    */
	   public void cancelAlertPopUp(WebDriver driver)
	   {
		   driver.switchTo().alert().dismiss();
	   }
	   
	   /**
	    * This method will scroll to the particular element
	    * @param driver
	    * @param element
	    */
	   public void scrollToWebElement(WebDriver driver, WebElement element) {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		  int y= element.getLocation().getY();
		   js.executeScript("window.scrollBy(0,"+y+")", element);
	   }
	   
	   /**
	    * This method will scroll down to the webpage
	    * @param driver
	    */
	   public void scrollToWebElement(WebDriver driver) {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollTo(0,0)");
	   }
	   
	   /**
	    * This method is used to switch between the frames with index value
	    * @param driver
	    * @param index
	    */
	   public void switchFrame(WebDriver driver,int index) {
	    	driver.switchTo().frame(index);
	    }   
	   
	   /**
	    * This method will switch between the frames with the element
	    * @param driver
	    * @param element
	    */
	   public void switchFrame(WebDriver driver,WebElement element) {
	    	driver.switchTo().frame(element);
	    } 
	   
	   /**
	    * This  method will switch between the frames with id or name
	    * @param driver
	    * @param idOrName
	    */
	   public void switchFrame(WebDriver driver,String idOrName) {
	    	driver.switchTo().frame(idOrName);
	    } 
	   
	   /**
	    * This method is used to take screenshot of failed test cases 
	    * @param driver
	    * @param screenshotName
	    * @throws Throwable
	    */
	   public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File src=ts.getScreenshotAs(OutputType.FILE);
	    	File dest=new File("./screenshot/"+screenshotName+".PNG");
	    	Files.copy(src, dest);
	    }
	   
	  
}
