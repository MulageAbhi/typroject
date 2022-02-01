package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibrary.BaseAnnotationClass;

public class Retrysimple extends BaseAnnotationClass {
	
	@Test(retryAnalyzer = com.vtiger.comcast.genericLibrary.RetryImp.class)
	public void simpleRetry() {
		Assert.assertEquals("A", "B");
	}

}
