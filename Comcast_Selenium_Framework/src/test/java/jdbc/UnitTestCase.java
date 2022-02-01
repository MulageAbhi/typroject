package jdbc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.vtiger.comcast.genericLibrary.JavaUtility;

public class UnitTestCase {

public static void main(String[] args) {
	JavaUtility jLib=new JavaUtility();
	String date = jLib.finalDate();
	System.out.println(date);
}

	
	}

