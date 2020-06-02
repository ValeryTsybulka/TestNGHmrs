package com.hrms.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class Bayram extends CommonMethods{
	@BeforeMethod
	public void openBrowser() {
		setUp();
	}
//Any method that is disabled, commented or in any case not executed then all depending methods will throw exception
	@Test(priority = 3,enabled =false)
	public void validLogin() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, ConfigsReader.getProperty("password"));
		WebElement loginBTN = driver.findElement(By.id("btnLogin"));
		loginBTN.click();
		WebElement logo=driver.findElement(By.xpath("//div[@id='branding']//img"));
		if(logo.isDisplayed()) {
			System.out.println("Successfully logged in.Test case PASSED!");
		}
	}
	@Test
	public void InvalidLogin() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		sendText(username, ConfigsReader.getProperty("username"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		sendText(password, "");
		WebElement loginBTN = driver.findElement(By.id("btnLogin"));
		loginBTN.click();
		String expectedMessage = "Password cannot be empty";
		WebElement errorMessage = driver.findElement(By.id("spanMessage"));
		String actualMessage = errorMessage.getText();
		if (expectedMessage.equals(actualMessage) && errorMessage.isDisplayed()) {
			System.out.println("Expected Message Displayed");
		} else {
			System.out.println("Test case not passed. Expected Message is not displayed");
		}
	}
	@AfterMethod
	public void closeBrowser() {
		tearDown();
}}
