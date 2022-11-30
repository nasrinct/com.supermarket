package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.PageUtility;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='inner']//p[text()='Manage Pages']")
	private WebElement box1;
	@FindBy(xpath = "//div[@class='inner']//p[text()='Admin Users']")
	private WebElement box2;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int get_noOfBoxes() {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		return generalutilities.get_SizeofWebElemntList("//div[@class='inner']");
	}

	public String getTextOfFirstBox() {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		return generalutilities.get_TextofElement(box1);
	}

	public String get_ColorOfBox2() {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);
		return generalutilities.get_CssValue(box2, "color");
	}

}
