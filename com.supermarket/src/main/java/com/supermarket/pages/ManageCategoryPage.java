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

public class ManageCategoryPage {

	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;

	@FindBy(xpath = "//a//i[@class='nav-icon fas fa-list-alt']")
	private WebElement manageCategory;
	@FindBy(xpath = "//p[text()='Category']")
	private WebElement category;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(css = "#category")
	private WebElement enterCategory;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement choosefile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement failedAlert;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnCategory() {
		manageCategory.click();
		category.click();

	}

	public void addNewCategory(String category, String xpath) {
		generalutilities = new GeneralUtilities(driver);
		newButton.click();
		enterCategory.sendKeys(category);
		discount.click();
		generalutilities.file_UploadUsingSendKeys(choosefile, xpath);
		pageutility = new PageUtility(driver);
		pageutility.clickUsingjs(saveButton);

	}

	public boolean isSuccessAlertDisplayed(String expected) {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(successAlert, expected);
	}

	public void refresh() {
		generalutilities = new GeneralUtilities(driver);
		generalutilities.refresh_Page();

	}

	public boolean isFailedAlertDisplayed(String expected) {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(failedAlert, expected);
	}

	public void clickOnEditCategory(String name) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		List<String> categoryNames = new ArrayList<String>();
		categoryNames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < categoryNames.size(); pos++) {
			if ((categoryNames.get(pos)).equals(name)) {
				pos++;
				break;
			}
		}

		driver.findElement(By.xpath("//tr[" + pos + "]//td[4]//a[@class='btn btn-sm btn btn-primary btncss']")).click();

	}

	public void editCategoryName(String name, String newcategoryName) {
		pageutility=new PageUtility(driver);
		clickOnEditCategory(name);
		enterCategory.clear();
		enterCategory.sendKeys(newcategoryName);
		pageutility.clickUsingjs(saveButton);

	}
}