package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	// encapsulate page object with private identifier so only we can access it
	// from public method
	private Page page;
	// 1.String Locators - OR

	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String MyaccountLink = "a[title='My Account']";
	private String loginLink = "a:text('Login')";

	// 2. page constructor;when we call HomePage constructor and pass the page parameter we 
	//initilazy(page) object of the class 
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods;
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("page title: " + title);
		return title;

	}

	public String getHomePageURL() {
		String url = page.url();
		System.out.println("page url: " + url);
		return url;
	}

	public String doSearch(String productName) {
		page.fill(search, productName);
		page.click(searchIcon);
		// page.locator(searchPageHeader).waitFor();
		String header = page.textContent(searchPageHeader);
		System.out.println("search header: " + header);
		return header;

	}

	public LoginPage navigateToLoginPage() {
		page.click(MyaccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

}
