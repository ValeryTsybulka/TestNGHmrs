package com.hrms.testcases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

	@Test(dataProvider = "userData", groups= {"homework","addEmp", "regression"})
	public void test(String firstName, String lastName, String username, String password) {
		System.out.println(firstName + " " + lastName + " " + username + " " + " " + password);
		// login into HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		wait(1);
		// navigate to Add Emplouee page
		dashboard.navigateToAddEmployee();
		wait(1);
		sendText(addEmp.firstName, firstName);
		sendText(addEmp.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = addEmp.empID.getAttribute("value");
		System.out.println("------------" + expectedEmpId + "------------------");
		// sendText(addEmp.empID, expectedEmpId+1);

		addEmp.checkboxLoginDetails.click();
		wait(1);

		sendText(addEmp.username, username);
		sendText(addEmp.userpassword, password);
		sendText(addEmp.re_password, password);
		wait(1);
		jsClick(addEmp.saveBtn);
		wait(1);
		// validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpID = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals(actualEmpID, expectedEmpId, "Employee ID did not match");

		takeScreenshot(firstName + "_" + lastName);

	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = { { "Serg", "Tyhanovsky", "rraj114", "Ad_min#0123" },
//				            { "John", "Smith", "john0224", "Ad_min#0123" },
//				            { "Mary", "Ann", "joy335", "Ad_min#0123" },
//				            { "Valery", "Tihon", "joy446", "Ad_min#0123" },
				            };
		return data;
	}

	@DataProvider(name = "userDataFromExel")
	public Object[][] getData2() {
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") +
				"\\src\\test\\resources\\testData\\Test4.xlsx", "Employee");

	}
}
