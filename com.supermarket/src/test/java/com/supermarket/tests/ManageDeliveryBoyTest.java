package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.base.DataProviders;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {

	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboypage;

	@Test(dataProvider = "DeliveryBoyDetails", dataProviderClass = DataProviders.class)
	public void verifyCreateNewDeliveryBoyOnDeliveryBoyList(String name, String email, String username,
			String password) {
		loginpage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboypage.clickOnManageDeliveryBoy();
		managedeliveryboypage.addNewDeliveryBoy(name, email, username, password);
		Assert.assertTrue(managedeliveryboypage.isSuccessAlertDisplayed(Constants.DELIVERYBOY_ADDED_SUCCESS));

	}

}
