package com.supermarket.constants;

public class Constants {

	public static final String CONFIGURE_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\configure.properties";
	public static final String SCREENSHOT_FILE_PATH = System.getProperty("user.dir") + "\\ScreenShots\\";
	public static final String EXTENTREPORT = System.getProperty("user.dir") + "\\ExtentReport";

	// ** LoginPage ** //
	public static final String EXPECTED_MESSAGE = "Alert!";
	public static final String EXPECTED_TEXT = "Remember Me";

	// ** HomePage ** //
	public static final int EXPECTEDNO_OFBOXES = 16;
	public static final String EXPECTEDtEXT_ONBOX1 = "Manage Pages";
	public static final String EXPECTEDCOLOR_OFBOX2 = "rgba(255, 255, 255, 1)";

	// ** AdminUserPage ** //
	public static final String EXPECTEDSTATUS = "Inactive";
	public static final String USER_CREATED_ALERT = "User Created Successfully";
	public static final String USER_DELETED_ALERT = "User Deleted Successfully";
	public static final String INVALID_USER = ".........RESULT NOT FOUND.......";
	public static final String USER_EDITED_ALERT = "User Updated Successfully";

	// ** PushNotificationsPage ** //
	public static final String PUSHNOTIFICATIONS_SEND = "Message send successfully";

	// ** ManageCategoryPage ** //
	public static final String CATEGORY_IMAGE_PATH_CHOCOLATE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\Images\\chocolate.jpg";
	public static final String CATEGORY_IMAGE_PATH_ICECREAM = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\Images\\icecream.jpg";
	public static final String CATEGORY_ADDED_SUCCESS = "Category Created Successfully";
	public static final String CATEGORY_ALREADY_EXIST = "Category already exists.";
	public static final String CATEGORY_UPDATE_SUCCESS = "Category Updated Successfully";
	public static final String CATEGORY_DELETE_SUCCESS = "Category Deleted Successfully";
	public static final String SUBCATEGORY_ADDED_SUCCESS = "Sub Category Created Successfully";

	// ** ManageDeliverBoyPage ** //
	public static final String DELIVERYBOY_ADDED_SUCCESS = "Delivery Boy Details Created Successfully";
	public static final String DELIVERYBOY_DELETED_SUCCESS = "Delivery Boy Informations Deleted Successfully";

	// ** ManageOrderPage ** //
	public static final String DELIVERY_DATE_CHANGED_SUCCESS = "Delivery Date Updated Successfully";
	public static final String DELIVERY_BOY_ASSIGNED_SUCCESS = "Delivery Boy Assigned Successfully";
	public static final String ORDER_DELETED_SUCCESS = "Order Deleted Successfully";

	// ** ManageLocationPage ** //
	public static final String LOCATION_ADDED_SUCCESS = "Location Created Successfully";
	public static final String LOCATION_DELETED_SUCCESS = "Location Deleted Successfully";

}
