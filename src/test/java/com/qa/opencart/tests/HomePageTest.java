package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;

public class HomePageTest {

	PlaywrightFactory pf;
	HomePage homePage;
	Page page;

	@BeforeTest
	public void setUp() {
		pf = new PlaywrightFactory();
		pf.initBrowser("chromium");
		page = pf.initBrowser("chromium");
		homePage = new HomePage(page);

	}

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

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
