package com.supermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.ScreenShot;
import com.supermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	/** automation_core **/

	public WebDriver driver;
	Properties prop = new Properties();
	FileInputStream ip;
	ScreenShot screenshot=new ScreenShot();;

	public Base() {
		try {
			ip = new FileInputStream(Constants.CONFIGURE_FILE_PATH);
			prop.load(ip);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WaitUtility.PAGE_LOAD));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));

	}

	@BeforeMethod(enabled = true,alwaysRun = true)
	public void setUp() {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		initialize(browser, url);

	}
	
	@Parameters("browser")
	@BeforeMethod(enabled = false)
	public void set_up(String browser) {
		String url = prop.getProperty("url");
		initialize(browser, url);
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult itestresult) {
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			screenshot.takeScreenshot(driver, itestresult.getName());
		}
		driver.close();
	}

}
