package com.supermarket.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.ScreenShot;

public class LoginTest extends Base {

	LoginPage loginpage;
	Excel excel = new Excel();

	@Test(priority = 1)
	public void verifyLogin() {
		String username = "nasrin";
		String password = "nasrin";
		String expectedUsername = "Nasrin";
		loginpage = new LoginPage(driver);
		loginpage.login(username, password);
		String actualUsername = loginpage.getLoginUserName();
		Assert.assertEquals(actualUsername, expectedUsername);

	}

	@Test(groups = "Smoke")
	public void verifyStaffLoginFunctionality() {
		loginpage = new LoginPage(driver);
		excel.setExcelFile("LoginData", "ValidLoginCredentials");
		String username = excel.getCellData(0, 0);
		String password = excel.getCellData(0, 1);
		loginpage.login(username, password);
		String expectedUsername = excel.getCellData(0, 2);
		String actualUsername = loginpage.getLoginUserName();
		Assert.assertEquals(actualUsername, expectedUsername);
	}

	@Test(groups = "Sanity")
	public void verifyInvalidLoginAlertMessage() {
		loginpage = new LoginPage(driver);
		excel.setExcelFile("LoginData", "InvalidLoginCredentials");
		String username = excel.getCellData(0, 0);
		String password = excel.getCellData(0, 1);
		loginpage.login(username, password);
		Assert.assertTrue(loginpage.invaliduserAlertMessagePresent(Constants.EXPECTED_MESSAGE));

	}

	@Test(groups = "Regression")
	public void verifyLoginpageText() {
		loginpage = new LoginPage(driver);
		String expetedText = "7rmart supermarket";
		String actualText = loginpage.getLoginpageText();
		Assert.assertEquals(actualText, expetedText);
	}

	@Test
	public void verifyChecboxIsEnabled() {
		loginpage = new LoginPage(driver);
		assertTrue(loginpage.checkBoxIsEnabled());

	}

	@Test
	public void verifyRemembermeCheckbox_isSelected() {
		loginpage = new LoginPage(driver);
		loginpage.clickonRememberMe();
		Assert.assertTrue(loginpage.remembeMeisSelected());

	}

	@Test
	public void verifyRememberMeCheckBoxText() {
		loginpage = new LoginPage(driver);
		Assert.assertEquals(loginpage.rememberMeCheckBoxText(), Constants.EXPECTED_TEXT,"REMEMBER ME");

	}
}
