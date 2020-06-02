package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;

public class LoginPageHRM extends CommonMethods {

	public WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
	public WebElement userName = driver.findElement(By.id("txtUsername"));
	public WebElement password = driver.findElement(By.id("txtPassword"));
	public WebElement btnLogin = driver.findElement(By.id("btnLogin"));
}
