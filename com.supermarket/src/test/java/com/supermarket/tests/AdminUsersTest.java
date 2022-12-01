package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtilities;

public class AdminUsersTest extends Base {

	LoginPage loginPage;
	AdminUsersPage adminuserpage;
	Excel excel = new Excel();
	GeneralUtilities generalutilities = new GeneralUtilities();
	
	@Test(description = "Create user")
	public void verifyAdminUserCreateNewUserFunctionality() {
		
		loginPage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginPage.login();
		adminuserpage.clickOnAdminUsers();
		excel.setExcelFile("LoginData", "createUser");
		String username = excel.getCellData(3, 0) + generalutilities.get_TimeStamp();
		String expectedUser = username;
		String password = excel.getCellData(3, 1);
		String type = excel.getCellData(3, 2);
		adminuserpage.createNewUser(username, password, type);
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(adminuserpage.isAlertDisplayed(Constants.USER_CREATED_ALERT),
				"user created successfully");
		adminuserpage.logOut();
		loginPage.login(username, password);
		softassert.assertEquals(loginPage.getLoginUserName(), expectedUser);
		softassert.assertAll();

	}

	@Test
	public void verifyAdminUserDeactivation() {
		loginPage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		String username = "jeff0";
		loginPage.login();
		adminuserpage.clickOnAdminUsers();
		adminuserpage.deactivateUser(username);
		Assert.assertEquals(adminuserpage.get_UserStatus(username), Constants.EXPECTEDSTATUS);

	}

	@Test
	public void verifyAdminUserSearchFunctionality() {
		loginPage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginPage.login();
		adminuserpage.clickOnAdminUsers();
		excel.setExcelFile("CreateUser", "newUserDetails");
		String username = excel.getCellData(3, 0) + generalutilities.get_TimeStamp();
		String password = excel.getCellData(3, 1);
		String type = excel.getCellData(3, 2);
		adminuserpage.createNewUser(username, password, type);
		adminuserpage.refresh_Page();
		String actualResult = adminuserpage.searchUser(username);
		Assert.assertEquals(actualResult, username);

	}

	@Test
	public void verifyDeleteUserFunctionality() {
		loginPage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginPage.login();
		adminuserpage.clickOnAdminUsers();
		excel.setExcelFile("CreateUser", "newUserDetails");
		String username = excel.getCellData(3, 0) + generalutilities.get_TimeStamp();
		String password = excel.getCellData(3, 1);
		String type = excel.getCellData(3, 2);
		adminuserpage.createNewUser(username, password, type);
		adminuserpage.refresh_Page();
		adminuserpage.deleteUser(username);
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(adminuserpage.isAlertDisplayed(Constants.USER_DELETED_ALERT),
				"user deleted successfully");
		String actualResult = adminuserpage.searchUser(username);
		softassert.assertEquals(actualResult, Constants.INVALID_USER);
		softassert.assertAll();

	}

	@Test
	public void verifyAdminUserEditFunctionality() {
		loginPage = new LoginPage(driver);
		adminuserpage = new AdminUsersPage(driver);
		loginPage.login();
		adminuserpage.clickOnAdminUsers();
		excel.setExcelFile("CreateUser", "newUserDetails");
		String username = excel.getCellData(3, 0) + generalutilities.get_TimeStamp();
		String password = excel.getCellData(3, 1);
		String type = excel.getCellData(3, 2);
		adminuserpage.clickOnEdit("johny9");
		adminuserpage.editUser(username, password, type);
		Assert.assertTrue(adminuserpage.isAlertDisplayed(Constants.USER_EDITED_ALERT));

	}
}
