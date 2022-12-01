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

public class ManageOrdersPage {
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	
	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrder;
	@FindBy(xpath = "//input[@name='del_up_date']")
	WebElement datepicker;
	@FindBy(xpath = "//input[@name='timepicker-one']")
	WebElement timePicker1;
	@FindBy(xpath = "//input[@name='timepicker-two']")
	WebElement timePicker2;
	@FindBy(xpath = "//button[@name='Update_st']")
	WebElement update;
	
	public ManageOrdersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnManageOrder() {
		manageOrder.click();
		
	}
	
	public void clickOnChangeDeliveryDate(String id) {
		GeneralUtilities generalutilities = new GeneralUtilities(driver);

		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(id)) {
				pos++;
				break;

			}
		}
		driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[@class='btn btn-primary btn-sm']")).click();
		
	}
	
	public void enterdDeliveryDate(String date) {
		datepicker.click();
		datepicker.sendKeys(date);
		
	}
	
	public void enterTimeBetween() {
		pageutility=new PageUtility(driver);
		pageutility.select_ByIndex(timePicker1, 3);
		pageutility.select_ByIndex(timePicker2, 4);
	}
	
	public void changeDeliveryDate(String id,String date) {
		clickOnChangeDeliveryDate(id);
		enterdDeliveryDate(date);
		enterTimeBetween();
		update.click();
	}

}
