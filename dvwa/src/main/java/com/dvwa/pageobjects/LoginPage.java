package com.dvwa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dvwa.actiondriver.Action;
import com.dvwa.base.base;

public class LoginPage extends base {

	Action action = new Action();
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='Login']")
	private WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//action
	//verification
	
	public HomePage clickOnLogin(String uname, String pswd, HomePage homePage) throws InterruptedException {
		action.type(username, uname);
		action.type(password, pswd);
		action.click(getDriver(), loginBtn);
		Thread.sleep(2000);
		return new HomePage();
	}
	
	
}
