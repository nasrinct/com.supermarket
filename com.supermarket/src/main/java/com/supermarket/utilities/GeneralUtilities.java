package com.supermarket.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralUtilities {
	
	WebDriver driver;
	Actions actions;
	
	public GeneralUtilities() {
		
	}
	
	public GeneralUtilities(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String get_TextofElement(WebElement element) {
		return element.getText();
	}
	
	public List<String> get_TextofElement(String xpath){
		List<String> texts=new ArrayList<String>();
		List<WebElement> elements=driver.findElements(By.xpath(xpath));
		
		for(WebElement i:elements) {
			texts.add(i.getText());
		}
		
		return texts;
		
	}
	
	public int get_SizeofWebElemntList(String xpath) {
		List<WebElement> elements=driver.findElements(By.xpath(xpath));
		return elements.size();
		
	}
	
	public String get_AttributeVaue(WebElement element,String attributeName) {
		return element.getAttribute(attributeName);
		
	}
	
	public String get_CssValue(WebElement element, String name) {
		return element.getCssValue(name);
	}
	
	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
		
	}
	
	public boolean is_Selected(WebElement element) {
		return element.isSelected();
		
	}
	
	public boolean is_Enabled(WebElement element) {
		return element.isEnabled();
		
	}
	
	public void clearTextField(WebElement element) {
		element.clear();
		
	}
		
	public String get_Title() {
		return driver.getTitle();
		
	}
	
	public String get_CurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	
	
	public boolean is_ExpectedTextPresent(WebElement element,String expectedText) {
		return element.getText().contains(expectedText);
	}
	
	public String get_TimeStamp() {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;

	}
	
	public String get_RandomNumber() {
		Random r=new Random();
		int x=r.nextInt(10);
		return String.valueOf(x);
		
	}
	
	public void file_UploadUsingSendKeys(WebElement element, String path) {
		element.sendKeys(path);
		
	}
	
	public void file_UploadUsingRobotClass(WebElement element, String path) {
		try {
			actions =new Actions(driver);
			element.click();
			Robot robot=new Robot();
			StringSelection ss=new StringSelection(path);
			
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			robot.delay(1000);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void refresh_Page() {
		driver.get(get_CurrentUrl());
	}
		
	}
