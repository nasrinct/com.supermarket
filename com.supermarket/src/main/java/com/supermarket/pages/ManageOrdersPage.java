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
import com.supermarket.utilities.WaitUtility;

public class ManageOrdersPage {
	WebDriver driver;
	GeneralUtilities generalutilities;
	PageUtility pageutility;
	WaitUtility waitutility;

	@FindBy(xpath = "//p[text()='Manage Orders']")
	private WebElement manageOrder;
	@FindBy(xpath = "//input[@name='del_up_date']")
	private WebElement datepicker;
	@FindBy(xpath = "//input[@name='timepicker-one']")
	private WebElement timePicker1;
	@FindBy(xpath = "//input[@name='timepicker-two']")
	private WebElement timePicker2;
	@FindBy(xpath = "//button[@name='Update_st']")
	private WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnManageOrder() {
		manageOrder.click();

	}

	public void changeDeliveryDate(String id, String date) {
		generalutilities = new GeneralUtilities(driver);

		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(id)) {
				pos++;
				break;

			}
		}
		driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[2]")).click();

		driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[2]/following-sibling::div//input[@type='date']"))
				.sendKeys(date);
		driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[2]/following-sibling::div//button[@name='Update_st']"))
				.click();

	}

	public boolean isSuccessAlertDisplayed(String expected) {
		generalutilities = new GeneralUtilities(driver);
		return generalutilities.is_ExpectedTextPresent(alert, expected);

	}

	public String changeStausOfOrder(String id, String newstatus) {
		waitutility = new WaitUtility(driver);
		pageutility = new PageUtility(driver);
		generalutilities = new GeneralUtilities(driver);

		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(id)) {
				pos++;
				break;

			}
		}
		driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[1]")).click();
		waitutility.wait_ElementTobeVisible(20,
				"//tr[" + pos + "]//td[6]//a[1]/following-sibling::div//select[@id='status']");
		WebElement selectstatus = driver
				.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[1]/following-sibling::div//select[@id='status']"));
		pageutility.select_ByValue(selectstatus, newstatus);
		driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[1]/following-sibling::div//button[@name='Update_st']"))
				.click();
		WebElement newStatus = driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//span[1])"));

		return generalutilities.get_TextofElement(newStatus);

	}

	public void assignDeliveryBoy(String id) {
		generalutilities = new GeneralUtilities(driver);
		pageutility = new PageUtility(driver);
		List<String> usernames = new ArrayList<String>();
		usernames = generalutilities.get_TextofElement("//tr//td[1]");
		int pos = 0;
		for (pos = 0; pos < usernames.size(); pos++) {
			if ((usernames.get(pos)).equals(id)) {
				pos++;
				break;

			}
		}
		driver.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[3]")).click();
		WebElement selectDeliveryBoy = driver
				.findElement(By.xpath("//tr[" + pos + "]//td[6]//a[3]/following-sibling::div//select"));
		pageutility.select_ByIndex(selectDeliveryBoy, 7);
		driver.findElement(
				By.xpath("//tr[" + pos + "]//td[6]//a[3]/following-sibling::div//button[@name='assign_del']")).click();

	}

	public void deleteFirstOrderinList() {
		driver.findElement(By.xpath("//tr[1]//td[7]//a[2]")).click();
		pageutility=new PageUtility(driver);
		pageutility.acceptAlert();

	}
}