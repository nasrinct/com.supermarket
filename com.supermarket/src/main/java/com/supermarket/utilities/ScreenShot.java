package com.supermarket.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.supermarket.constants.Constants;

public class ScreenShot {

	TakesScreenshot scrshot;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	int c;

	public void takeScreenshot(WebDriver driver, String imgName) {
		try {
			scrshot = (TakesScreenshot) driver;
			File screen_shot = scrshot.getScreenshotAs(OutputType.FILE);
			String timestamp = generalUtilities.get_TimeStamp();
			String destinationDirectory = Constants.SCREENSHOT_FILE_PATH + imgName + "_" + timestamp + ".png";
			File finalDestination = new File(destinationDirectory);
			FileHandler.copy(screen_shot, finalDestination);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
