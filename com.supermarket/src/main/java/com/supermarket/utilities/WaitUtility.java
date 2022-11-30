package com.supermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public static final long IMPLICIT_WAIT=10;
	public static final long PAGE_LOAD=10;
	
	WebDriver driver;
	WebDriverWait wait;
	Wait fluentWait;
	
	public WaitUtility(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void wait_ForElementTobeClickable(long second,String xpath) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public void wait_ElementTobeVisible(long second, String xpath) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void wait_ElementTobeInVisible(long second, String xpath) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void fluentwait_ElementTobeClickable(long second1,long second2, String xpath) {
		fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(second1)).pollingEvery(Duration.ofSeconds(second2)).ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
	}
	
	

	//popup alert
	
	

}
