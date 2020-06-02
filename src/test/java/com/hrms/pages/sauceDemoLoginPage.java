package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class sauceDemoLoginPage extends CommonMethods{
	
	@FindBy(id="user-name")
	public static WebElement username;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(xpath="//input[@class='btn_action']")
	public static WebElement loginButton;
	
	@FindBy(xpath="app_logo")
	public static WebElement logo;
	
	@FindBy(xpath = "//div[text()='Products']")
	public WebElement productText;

	@FindBy(xpath = "//h3[contains(text(),'Epic sadface')]")
	public WebElement errorMessage;
	
	public sauceDemoLoginPage() {
		PageFactory.initElements(BaseClass.driver, this);
			}	
	public static void loginToSauceDemo(String username1, String password1) {
		sendText(username, username1);
		sendText(password, password1);
		wait(2);
		click(loginButton);
	}
	

}
