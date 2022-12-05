package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;
import com.supermarket.utilities.ScreenShot;

public class AdminUsersPage {

	WebDriver driver;

	@FindBy(xpath = "//a//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsers;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(css = "#username")
	private WebElement usernameField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@name='user_type']")
	private WebElement usertype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//img[@class='img-circle']")
	private WebElement profile;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	private WebElement logout;
	@FindBy(css = ".btn.btn-rounded.btn-primary")
	private WebElement search;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement searchusername;
	@FindBy(xpath = "//button[@value='sr']")
	private WebElement searchButton;
	@FindBy(xpath = "//tr[1]//td[1]")
	private WebElement searchResult;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement update;

	ScreenShot obj = new ScreenShot();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminUsers() {
		PageUtility pageutility = new PageUtility(driver);
		pageutility.mouse_ClickOnSpecificElement(adminUsers);
	}

	public void createNewUser(String username, String password, String type) {
		newButton.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		usertype.click();
		selectType(type);
		save.click();

	}

	public void selectType(String type) {
		PageUtility pageutility = new PageUtility(driver);
		if (type.equalsIgnoreCase("Staff")) {
			pageutility.select_ByVisibleText(usertype, "Staff");

		} else if (type.equalsIgnoreCase("Admin")) {
			pageutility.select_ByVisibleText(usertype, "Admin");

		} else if (type.equalsIgnoreCase("Partner")) {
			pageutility.select_ByVisibleText(usertype, "Partner");

		} else if (type.equalsIgnoreCase("Delivery Boy")) {
			pageutility.select_ByVisibleText(usertype, "Delivery Boy");

		}
	}

	public boolean isAlertDisplayed(String expected) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(alert, expected);

	}

	public void logOut() {
		profile.click();
		logout.click();

	}

	public void deactivateUser(String userName) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);

		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(userName)) {
				pos++;
				break;

			}
		}

		if (get_UserStatus(userName).equals("Active")) {
			driver.findElement(By.xpath("//tr[" + pos + "]//td[5]//a[1]")).click();

		}
	}

	public String get_UserStatus(String userName) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(userName)) {
				pos++;
				break;

			}
		}
		return generalutilities.get_TextofElement(driver.findElement(By.xpath("//tr[" + pos + "]//td[3]")));
	}

	public void refresh_Page() {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		generalutilities.refresh_Page();

	}

	public String searchUser(String username) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		search.click();
		searchusername.sendKeys(username);
		searchButton.click();
		return generalutilities.get_TextofElement(searchResult);

	}

	public void deleteUser(String userName) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(userName)) {
				pos++;
				break;

			}
		}
		driver.findElement(By.xpath("//tr[" + pos + "]//td[5]//a[3]")).click();
		PageUtility pageutility=new PageUtility(driver);
		pageutility.acceptAlert();
	}

	public void clickOnEdit(String userName) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(userName)) {
				pos++;
				break;

			}
		}
		driver.findElement(By.xpath("//tr[" + pos + "]//td[5]//a[2]")).click();

	}

	public void editUser(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
		update.click();

	}
}
