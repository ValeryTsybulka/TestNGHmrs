package com.hrms.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {
	
	
	public static WebDriver driver;
	//ExtentHtmlReporter htmlReport;
	//ExtentReports report;
	
	@BeforeMethod//to make this method run before every @Test method
	public static WebDriver setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		 System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}
		//driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit)
		driver.get(ConfigsReader.getProperty("url"));
		
		//initiolize all page objects as part of setup
		PageInitializer.initialize();
		return driver;
	}

	@AfterMethod//to make this method run after every @Test method
	public static void tearDown() {
		if (driver != null) {// if driver=null we will get NullPointerException
			driver.quit();
		}
	}
}
