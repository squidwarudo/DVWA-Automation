package com.dvwa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dvwa.actiondriver.Action;
import com.dvwa.base.base;


public class CommandInjectionPage extends base {

	Action action= new Action();
	
	@FindBy(xpath="//h1[normalize-space()='Vulnerability: Command Injection']")
	private WebElement CIAssert;
	
	@FindBy(xpath="//input[@name='ip']")
	private WebElement EnterIP;
	
	@FindBy(xpath="//input[@name='Submit']")
	private WebElement SubmitIP;
	
	
	
	
	public CommandInjectionPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyCommandInjectionPage() {
		return action.isDisplayed(getDriver(), CIAssert);
	}
	
	public void EnterIP(String ip) {
		action.type(EnterIP, ip);
		action.click(getDriver(), SubmitIP);		
	}
	
}
