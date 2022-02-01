package com.vtiger.comcast.genericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryImp implements IRetryAnalyzer{

	int count=0;
	int retrylimit=3;
	
	public boolean retry(ITestResult result) {
		if(count<retrylimit) {
			count++;
			return true;
		}
		return false;
	}
	
}
