package com.hrms.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test(groups="smoke")
	public void validAdminLogin() {
		// LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		// DashboardPageElements db = new DashboardPageElements();
		String actualUser = dashboard.welcome.getText();
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}

	@Test(groups="regression")
	public void invalidPasswordLogin() {
		// LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "qwqwqw");
		click(login.loginBtn);

		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not macht");
	}
	@Test(enabled=true, groups="regression")
	public void emptyUsernameLogin() {
		//LoginPageElements login = new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		String expected="Username cannot be empty";

		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	
}
