package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	// in our POM design pattern we write repetetive steps under a method
	// every test class can use it

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Page page;
	Properties prop;

	public Page initBrowser(Properties prop) {
        
		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name is : " + browserName);

		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {
		case "chromium":
			/**
			 * Basically what we are doing is we create a browser context and in that context 
			 * we initialize a page instance so this page can interacts elements inside that browser  
			 */
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "chrome":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;

		default:
			System.out.println("please pass the right browser name.....");
			break;
		}

		browserContext = browser.newContext();
		page = browserContext.newPage();
		String url=prop.getProperty("url");
		page.navigate(url);

		return page; 

	}
	
	/**
	 * this method is to initialize the propeerties friom config file 
	 * @throws FileNotFoundException 
	 */
	
	    public Properties init_prop() {
	    	
	    	try {
				FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
				prop = new Properties();
				//this prop variable will load all properties from fileinput stream class as key and value 
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	 
	    	   return prop;
	    	
	    	
	    }

}
