package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {

	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;

	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	WebElement manageDeliveryBoy;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement enter_name;
	@FindBy(xpath = "//input[@id='email']")
	WebElement enter_email;
	@FindBy(xpath = "//input[@id='username']")
	WebElement enter_username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement enter_password;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnManageDeliveryBoy() {
		manageDeliveryBoy.click();

	}

	public void addNewDeliveryBoy(String name, String email, String username, String password) {
		newButton.click();
		enterName(name);
		enterEmail(email);
		enterUsername(username);
		enterPassword(password);
		clickOnSave();

	}

	public void enterName(String name) {
		enter_name.sendKeys(name);

	}

	public void enterUsername(String username) {
		enter_username.sendKeys(username);

	}

	public void enterEmail(String email) {
		enter_email.sendKeys(email);

	}

	public void enterPassword(String pass) {
		enter_password.sendKeys(pass);

	}

	public void clickOnSave() {
		pageutility = new PageUtility(driver);
		pageutility.clickUsingjs(save);
	}

	public boolean isSuccessAlertDisplayed(String expected) {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(successAlert, expected);

	}

}
