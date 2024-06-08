package com.dvwa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dvwa.actiondriver.Action;
import com.dvwa.base.base;

public class BruteForcePage extends base{

	Action action = new Action();
	
	@FindBy(xpath="//h1[normalize-space()='Vulnerability: Brute Force']")
	private WebElement BruteForceAssert;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement BFusername;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement BFpass;
	
	@FindBy(xpath="//input[@name='Login']")
	private WebElement BFlogin;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[3]/div[1]/div[1]/pre[1]")
	private WebElement BFloginAssert;
	
	
	
	public BruteForcePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyBruteForcePage() {
		return action.isDisplayed(getDriver(), BruteForceAssert);
	}
	
	public void bruteForceLogin(String uname, String pswd) {
		action.type(BFusername, uname);
		action.type(BFpass, pswd);
		action.click(getDriver(), BFlogin);
	}
	
	public boolean verifyBruteForceLogin() {
		return action.isDisplayed(getDriver(), BFloginAssert);
	}
	
}
