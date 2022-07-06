package com.qa.opencart.tests;
import java.nio.file.AccessDeniedException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		// this method will return us object of LoginPage
		loginPage = homePage.navigateToLoginPage();
		String loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("page act title:" + loginPageTitle);
		Assert.assertEquals(loginPageTitle, AppConstants.LOGIN_PAGE_TITLE);

	}
	
	@Test(priority = 2)
	public void forgotPwdLinkExistTest() {
		// since it will return boolean we can assert it 
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority = 3)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim()));
		
	}
	

}
