package com.supermarket.tests;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
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
		manageorderspage.changeDeliveryDate("401", "01.12.2022");
	}

}
