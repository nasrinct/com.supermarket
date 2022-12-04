package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.Excel;

public class HomeTest extends Base {
	LoginPage loginPage;
	HomePage homepage;
	Excel excel;

	@Test(description = "TestCase 1")
	public void verifyNoOfBboxesinAdminHomePage() {
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginPage.login();
		Assert.assertEquals(homepage.get_noOfBoxes(), Constants.EXPECTEDNO_OFBOXES);

	}

	@Test
	public void verifyTextOfFirstBox() {
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginPage.login();
		Assert.assertEquals(homepage.getTextOfFirstBox(), Constants.EXPECTEDtEXT_ONBOX1);

	}

	@Test
	public void verifyColorOfBox2() {
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginPage.login();
		Assert.assertEquals(homepage.get_ColorOfBox2(), Constants.EXPECTEDCOLOR_OFBOX2);
	}

	@Test
	public void verifyTextHomeContainsHomePageLink() {
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginPage.login();
		homepage.clickOnDashboard();
		Assert.assertEquals(homepage.getLinkofHome(), homepage.get_CurrentUrl());

	}
}
