package com.supermarket.base;

import org.testng.annotations.DataProvider;

import com.supermarket.utilities.Excel;

public class DataProviders {
	Excel excel=new Excel();

	@DataProvider(name = "Invalid Logins")
	public Object[][] methodInvalidLogin() {
		excel.setExcelFile("LoginData", "InvalidLoginCredentials");
		Object data[][] = excel.getMultiDimensionalData(4, 2);
		return data;

	}
	
	@DataProvider(name= "DeliveryBoyDetails")
	public Object[][] methodCreatenewDeliveryBoy(){
		excel.setExcelFile("ManageDeliveryBoy", "deliveryBoyDetails");
		Object data[][]=excel.getMultiDimensionalData(3, 4);
		return data;
	}

}
