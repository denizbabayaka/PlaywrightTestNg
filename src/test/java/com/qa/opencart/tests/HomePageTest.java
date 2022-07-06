package com.qa.opencart.tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class HomePageTest extends BaseTest {

	

	

	@Test

	public void homePageTitleTest() {

		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);

	}

	@Test
	public void homePageURLTest() {
		String actualUrl = homePage.getHomePageURL();
		Assert.assertEquals(actualUrl, prop.getProperty("url"));
	}
	
	@DataProvider
	public Object getProductData() {
		return new Object[] [] {
			{"Macbook"},
			{"iMac"},
			{"Samsung"}
			
		};
	}

	@Test(dataProvider ="getProductData")
	public void searchtest(String productName) {
		String actualHeader=homePage.doSearch(productName); 
		Assert.assertEquals(actualHeader, "Search - "+productName);
	}



}
