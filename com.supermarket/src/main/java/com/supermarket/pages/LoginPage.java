package com.supermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	Properties prop = new Properties();
	FileInputStream ip;
	GeneralUtilities generalutilities;

	//@CacheLookup
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameElement;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileOwnerName;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement loginalert;
	@FindBy(xpath = "//b")
	private WebElement supermarket;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberMe;
	@FindBy(xpath = "//div[@class='icheck-dark']//input[@id='remember']")
	private WebElement rememberMeElement;

	public LoginPage(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			ip = new FileInputStream(Constants.CONFIGURE_FILE_PATH);
			prop.load(ip);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void enterUsername(String username) {
		usernameElement.sendKeys(username);

	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);

	}

	public void clickOnSignInButton() {
		signInButton.click();

	}

	public void login() {
		String username = prop.getProperty("userName");
		String password = prop.getProperty("password");
		login(username, password);

	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickOnSignInButton();

	}

	public String getLoginUserName() {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.get_TextofElement(profileOwnerName);

	}

	public boolean invaliduserAlertMessagePresent(String expected) {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(loginalert, expected);

	}

	public String getLoginpageText() {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.get_TextofElement(supermarket);

	}

	public boolean checkBoxIsEnabled() {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_Enabled(rememberMe);

	}

	public boolean remembeMeisSelected() {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_Selected(rememberMeElement);

	}

	public void clickonRememberMe() {
		rememberMe.click();

	}

	public String rememberMeCheckBoxText() {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.get_TextofElement(rememberMe);

	}
}
