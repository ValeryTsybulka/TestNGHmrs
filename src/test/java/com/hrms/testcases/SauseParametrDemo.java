package com.hrms.testcases;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;

public class SauseParametrDemo extends CommonMethods{
	@Parameters({"userName", "paswrd"})

	@Test
	public void login(String userName, String paswrd) {
		sendText(ss.username, userName);
		sendText(ss.password, paswrd);
		click(ss.loginButton);

		wait(3);
	}
}
