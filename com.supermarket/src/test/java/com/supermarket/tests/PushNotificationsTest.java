package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;
import com.supermarket.utilities.Excel;

public class PushNotificationsTest extends Base {

	LoginPage loginPage;
	PushNotificationsPage pushNotificationspage;
	Excel excel = new Excel();

	@Test(groups = {"Sanity","Smoke"})
	public void verifyPushNotificationsFunctionality() {
		loginPage = new LoginPage(driver);
		pushNotificationspage = new PushNotificationsPage(driver);
		loginPage.login();
		pushNotificationspage.clickOnPushNotifications();
		excel.setExcelFile("PushNotifications", "notifications");
		String title = excel.getCellData(2, 0);
		String description = excel.getCellData(2, 1);
		pushNotificationspage.typeNotifications(title, description);
		pushNotificationspage.clickOnSend();
		Assert.assertTrue(pushNotificationspage.isPushNotificationsAlertDisplayed(Constants.PUSHNOTIFICATIONS_SEND));
	}

	@Test
	public void verifyResetButtonFunctionality() {
		loginPage = new LoginPage(driver);
		pushNotificationspage = new PushNotificationsPage(driver);
		loginPage.login();
		pushNotificationspage.clickOnPushNotifications();
		excel.setExcelFile("PushNotifications", "notifications");
		String title = excel.getCellData(2, 0);
		String description = excel.getCellData(2, 1);
		pushNotificationspage.typeNotifications(title, description);
		pushNotificationspage.clickOnReset();
		Assert.assertTrue(pushNotificationspage.isNotificationsCleared());

	}

}
