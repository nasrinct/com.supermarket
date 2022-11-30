package com.supermarket.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;

	}

	// js index..scroll into view..click
	// file upload 2..robot

	// driver.switch to
	// alerts

	public void select_ByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void select_ByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public void select_ByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void click_usingMouse() {
		actions = new Actions(driver);
		actions.click().build().perform();
	}
	
	public void mouse_ClickOnSpecificElement(WebElement element) {
		actions=new Actions(driver);
		actions.click(element).build().perform();
		
	}
	
	public void move_ToElementUsingActions(WebElement element) {
		actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
		
	}

	public void scrollDowntoIndexUsingjs(int x, int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)", "");

	}

	public void scrollIntoViewUsingjs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void clickUsingjs(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void fileUpload(WebElement element, String path) {
		try {
			File file = new File(path);
			element.sendKeys(file.getAbsolutePath());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void fileUploadUsingRobotClass(WebElement element, String path) throws AWTException {
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

		Robot robot = new Robot();
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public void switchtoNewWindow() {

	}

	public boolean is_Visible(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean is_Clicked(WebElement element) {
		try {
			element.click();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void scrollAndClick(WebElement element) {
		int x = 0;
		js = (JavascriptExecutor) driver;
		while (is_Clicked(element)) {
			js.executeScript("window.scrollBy(0," + x + ")");
			x=x+20;

			
		}

	}

}
