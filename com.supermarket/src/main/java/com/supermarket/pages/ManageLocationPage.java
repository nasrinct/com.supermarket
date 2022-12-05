package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class ManageLocationPage {

	WebDriver driver;
	PageUtility pageutility;
	GeneralUtilities generalutilities;

	@FindBy(xpath = "//p[text()='Manage Location']")
	private WebElement manageLocation;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//select[@name='country_id']")
	private WebElement country;
	@FindBy(xpath = "//select[@name='state_id']")
	private WebElement state;
	@FindBy(css = "#location")
	private WebElement location;
	@FindBy(css = "#delivery")
	private WebElement deliverycharge;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//tr[1]//td[6]//a[2]")
	private WebElement delete;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickonManageLocation() {
		manageLocation.click();
	}

	public void addNewLocation(String location, String deliveryCharge) {
		newButton.click();
		selectCountry();
		selectState();
		enterLocation(location);
		enterDeliveryCharge(deliveryCharge);
		clickOnSave();

	}

	public void selectCountry() {
		pageutility = new PageUtility(driver);
		pageutility.select_ByIndex(country, 1);

	}

	public void selectState() {
		pageutility = new PageUtility(driver);
		pageutility.select_ByIndex(state, 9);
	}

	public void enterLocation(String loc) {
		location.sendKeys(loc);

	}

	public void enterDeliveryCharge(String charge) {
		deliverycharge.sendKeys(charge);
	}

	public void clickOnSave() {
		pageutility.scrollAndClick(save);

	}

	public boolean isSuccessAlertDisplayed(String expected) {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(alert, expected);

	}

	public void deleteFirstLocationfromList() {
		delete.click();
		pageutility=new PageUtility(driver);
		pageutility.acceptAlert();

	}

}
