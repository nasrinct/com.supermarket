package com.supermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.constants.Constants;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrdersPage;

public class ManageOrderTest extends Base{
	
	LoginPage loginPage;
	ManageOrdersPage manageorderspage;
	
	@Test
	public void verifyChangeDateinManageOrderPage() {
		loginPage=new LoginPage(driver);
		manageorderspage=new ManageOrdersPage(driver);
		loginPage.login();
		manageorderspage.clickOnManageOrder();
		manageorderspage.changeDeliveryDate("389", "01.12.2022");
		Assert.assertTrue(manageorderspage.isSuccessAlertDisplayed(Constants.DELIVERY_DATE_CHANGED_SUCCESS));
		
	}
	
	@Test
	public void  verifyChangeStatusinManageOrderList() {
		loginPage=new LoginPage(driver);
		manageorderspage=new ManageOrdersPage(driver);
		loginPage.login();
		manageorderspage.clickOnManageOrder();
		String newStatus="Delivered";
		String actualStatus=manageorderspage.changeStausOfOrder("379",newStatus);
		String expectedStatus=newStatus;
		Assert.assertEquals(actualStatus, expectedStatus);
		
	}
	
	@Test
	public void verifyAssignDeliverBoyFunctionality() {
		loginPage=new LoginPage(driver);
		manageorderspage=new ManageOrdersPage(driver);
		loginPage.login();
		manageorderspage.clickOnManageOrder();
		manageorderspage.assignDeliveryBoy("389");
		Assert.assertTrue(manageorderspage.isSuccessAlertDisplayed(Constants.DELIVERY_BOY_ASSIGNED_SUCCESS));
		
	}
	
	@Test
	public void verifyDeleteOrderFunctionality() {
		loginPage=new LoginPage(driver);
		manageorderspage=new ManageOrdersPage(driver);
		loginPage.login();
		manageorderspage.clickOnManageOrder();
		manageorderspage.deleteFirstOrderinList();
		Assert.assertTrue(manageorderspage.isSuccessAlertDisplayed(Constants.ORDER_DELETED_SUCCESS));
	}
	

}
