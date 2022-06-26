package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class HomePageTest extends BaseTest {

	

	

	@Test

	public void homePageTitleTest() {

		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, "Your Store");

	}

	@Test
	public void homePageURLTest() {
		String actualUrl = homePage.getHomePageURL();
		Assert.assertEquals(actualUrl, "https://naveenautomationlabs.com/opencart/");
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
