package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageCategoryPage;
import com.supermarket.utilities.Excel;
import com.supermarket.utilities.GeneralUtilities;

public class ManageCategoryTest extends Base {

	LoginPage loginPage;
	ManageCategoryPage managecategorypage;
	Excel excel = new Excel();
	GeneralUtilities generalutilities = new GeneralUtilities();

	@Test(priority = 1)
	public void verifyManageCategoryAddCategoryFunctionality() {
		loginPage = new LoginPage(driver);
		managecategorypage = new ManageCategoryPage(driver);
		loginPage.login();
		managecategorypage.clickOnCategory();
		excel.setExcelFile("ManageCategory", "categories");
		String category = excel.getCellData(0, 0);
		managecategorypage.addNewCategory(category + generalutilities.get_TimeStamp(),
				Constants.CATEGORY_IMAGE_PATH_CHOCOLATE);
		Assert.assertTrue(managecategorypage.isSuccessAlertDisplayed(Constants.CATEGORY_ADDED_SUCCESS),
				"Category Created Successfully");

	}

	@Test(dependsOnMethods = "verifyManageCategoryAddCategoryFunctionality")
	public void verirfyDuplicationIsNotPossibleInManageCategoryList() {
		loginPage = new LoginPage(driver);
		managecategorypage = new ManageCategoryPage(driver);
		loginPage.login();
		managecategorypage.clickOnCategory();
		excel.setExcelFile("ManageCategory", "categories");
		String category = excel.getCellData(0, 0) + generalutilities.get_RandomNumber();
		managecategorypage.addNewCategory(category, Constants.CATEGORY_IMAGE_PATH_CHOCOLATE);
		managecategorypage.refresh();
		managecategorypage.clickOnCategory();
		managecategorypage.addNewCategory(category, Constants.CATEGORY_IMAGE_PATH_CHOCOLATE);
		Assert.assertTrue(managecategorypage.isFailedAlertDisplayed(Constants.CATEGORY_ALREADY_EXIST),
				"Category already exist");

	}

	@Test(priority = 2)
	public void verifyManageCategoryEditButtonFunctionality() {
		loginPage = new LoginPage(driver);
		managecategorypage = new ManageCategoryPage(driver);
		SoftAssert softassert = new SoftAssert();
		loginPage.login();
		managecategorypage.clickOnCategory();
		excel.setExcelFile("ManageCategory", "categories");
		String category = excel.getCellData(1, 0) + generalutilities.get_RandomNumber();
		managecategorypage.addNewCategory(category, Constants.CATEGORY_IMAGE_PATH_ICECREAM);
		softassert.assertTrue(managecategorypage.isSuccessAlertDisplayed(Constants.CATEGORY_ADDED_SUCCESS),
				"Category Created Successfully");
		managecategorypage.clickOnCategory();
		managecategorypage.editCategoryName(category, "ice" + generalutilities.get_TimeStamp());
		softassert.assertTrue(managecategorypage.isSuccessAlertDisplayed(Constants.CATEGORY_UPDATE_SUCCESS),
				"Category Updated Successfully");
		softassert.assertAll();

	}

	@Test
	public void verifyManageCategoryDeleteFunctionality() {
		loginPage = new LoginPage(driver);
		managecategorypage = new ManageCategoryPage(driver);
		SoftAssert softassert = new SoftAssert();
		loginPage.login();
		managecategorypage.clickOnCategory();
		excel.setExcelFile("ManageCategory", "categories");
		String category = excel.getCellData(1, 0) + generalutilities.get_RandomNumber();
		managecategorypage.addNewCategory(category, Constants.CATEGORY_IMAGE_PATH_ICECREAM);
		softassert.assertTrue(managecategorypage.isSuccessAlertDisplayed(Constants.CATEGORY_ADDED_SUCCESS),
				"Category Created Successfully");
		managecategorypage.clickOnCategory();
		managecategorypage.deleteCategory(category);
		softassert.assertTrue(managecategorypage.isSuccessAlertDisplayed(Constants.CATEGORY_DELETE_SUCCESS));
		softassert.assertAll();

	}

	@Test
	public void verifySubCategoryNewButtonFunctionality() {
		loginPage = new LoginPage(driver);
		managecategorypage = new ManageCategoryPage(driver);
		loginPage.login();
		managecategorypage.clickOnSubCategory();
		excel.setExcelFile("ManageCategory", "subcategories");
		String category = excel.getCellData(1, 0);
		String subcategory = excel.getCellData(1, 1) + generalutilities.get_RandomNumber();
		managecategorypage.addnewSubcategory(category, subcategory, Constants.CATEGORY_IMAGE_PATH_ICECREAM);
		Assert.assertTrue(managecategorypage.isSuccessAlertDisplayed(Constants.SUBCATEGORY_ADDED_SUCCESS));

	}

}
