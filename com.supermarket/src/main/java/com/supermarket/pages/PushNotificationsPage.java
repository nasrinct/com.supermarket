package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class PushNotificationsPage {

	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;

	@FindBy(xpath = "//a//i[@class='nav-icon fas fa-fas fa-bell']")
	private WebElement pushNotifications;
	@FindBy(css = "#title")
	private WebElement title;
	@FindBy(css = "#description")
	private WebElement description;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement send;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//a[text()='Reset']")
	private WebElement reset;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnPushNotifications() {
		pushNotifications.click();
	}

	public void typeNotifications(String title_, String description_) {
		title.sendKeys(title_);
		description.sendKeys(description_);

	}

	public void clickOnSend() {
		send.click();

	}

	public boolean isPushNotificationsAlertDisplayed(String expected) {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(alert, expected);

	}

	public void clickOnReset() {
		reset.click();

	}

	public boolean isNotificationsCleared() {
		generalutilities = new GeneralUtilities(driver);
		String t = generalutilities.get_TextofElement(title);
		String d = generalutilities.get_TextofElement(description);
		return (t.isEmpty() && d.isEmpty());
	}

}
