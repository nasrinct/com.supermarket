package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageLocationPage;
import com.supermarket.utilities.Excel;

public class ManageLocationTest extends Base {

	LoginPage loginpage;
	ManageLocationPage managelocation;
	Excel excel = new Excel();

	@Test
	public void verifyAddNewLoactioninLocationList() {
		loginpage = new LoginPage(driver);
		managelocation = new ManageLocationPage(driver);
		loginpage.login();
		managelocation.clickonManageLocation();
		excel.setExcelFile("ManageLocation", "Location");
		String location = excel.getCellData(1, 0);
		String deliveryCharge = excel.getCellData(1, 1);
		managelocation.addNewLocation(location, deliveryCharge);
		Assert.assertTrue(managelocation.isSuccessAlertDisplayed(Constants.LOCATION_ADDED_SUCCESS));

	}

	@Test
	public void verifyDeleteLocationFromListFunction() {
		loginpage = new LoginPage(driver);
		managelocation = new ManageLocationPage(driver);
		loginpage.login();
		managelocation.clickonManageLocation();
		managelocation.deleteFirstLocationfromList();
		Assert.assertTrue(managelocation.isSuccessAlertDisplayed(Constants.LOCATION_DELETED_SUCCESS));

	}

}
