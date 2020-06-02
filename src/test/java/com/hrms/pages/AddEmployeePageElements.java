package com.hrms.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {
	@FindBy(id="welcome")
	public WebElement welcom;
	
	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "lastName")
	public WebElement lastName;

	@FindBy(id = "employeeId")
	public WebElement empID;
	
	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;
	
	@FindBy(id = "user_name")
	public WebElement username;
	
	@FindBy(id = "user_password")
	public WebElement userpassword;
	
	@FindBy(id = "re_password")
	public WebElement re_password;

	@FindBy(xpath = "//*[@id=\"btnSave\"]")
	public WebElement saveBtn;
	
	
	
	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	
	@FindBy(xpath="//*[@id=\"empPic\"]")
	public WebElement photo;
	
	@FindBy(xpath="//span[text()='Required']")
	public WebElement required;

	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
			}	
	public void addEmp(String fn, String ln, String id) {
			sendText(firstName, fn);
			sendText(lastName, ln);
			sendText(empID, id);
			wait(3);
			//click(save);
		}
		
	}


