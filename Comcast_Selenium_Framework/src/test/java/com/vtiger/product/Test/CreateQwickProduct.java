package com.vtiger.product.Test;

import org.testng.annotations.Test;

import com.vtiger.comcast.genericLibrary.BaseAnnotationClass;
import com.vtiger.comcast.pomrepositorylib.HomePage;

public class CreateQwickProduct extends BaseAnnotationClass {

	@Test
	public void createProduct() {
		
		HomePage hp=new HomePage(driver);
		hp.getPrductlnk().click();
		
	}
}
