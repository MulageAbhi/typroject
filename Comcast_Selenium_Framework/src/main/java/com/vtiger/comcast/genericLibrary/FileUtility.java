package com.vtiger.comcast.genericLibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains generic methods to read the data from the property file 
 * @author Admin
 *
 */
public class FileUtility {

	/**
	 * This is the generic method to read the data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String key) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
}
