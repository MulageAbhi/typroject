package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibrary.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositorylib.HomePage;

@Listeners(com.vtiger.comcast.genericLibrary.LisImpClass.class)
public class SampleListener extends BaseAnnotationClass{

	@Test
	public void contest() {
		HomePage h=new HomePage(driver);
		h.getCont().click();
		
		Assert.assertEquals("A", "B");
	}

}
