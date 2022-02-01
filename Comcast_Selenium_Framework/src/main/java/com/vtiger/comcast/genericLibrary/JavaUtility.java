package com.vtiger.comcast.genericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Admin
 *
 */
public class JavaUtility {

	/**
	 * This method is used to enerate random number between 1 to 100
	 * @return
	 */
	public int getRandomNumber(){
		Random ran=new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	/**
	 * This method id is used to generate the system date
	 * @return
	 */
	public String getDate() {
		Date date=new Date();
		String sysDate = date.toString();
		return sysDate;
	}
	
	/**
	 * This method is used to get the customised date
	 * @return
	 */
	public String finalDate() {
		Date date=new Date();
		String d = date.toString();
		String[] dt = d.split(" ");
		String YYYY = dt[5];
		String MM = dt[1];
		String DD = dt[2];
		String dte = YYYY+"/"+MM+"/"+DD;
		return dte;
	}
	
	/**
	 * This method is used to perform the virtual key operations
	 * @throws AWTException
	 */
	public void gatRobotClass() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
