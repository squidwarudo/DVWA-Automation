package com.dvwa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dvwa.actiondriver.Action;
import com.dvwa.base.base;


public class HomePage extends base {
	
	Action action = new Action();

	@FindBy(xpath="//h1[normalize-space()='Welcome to Damn Vulnerable Web Application!']")
	private WebElement DVWAAssert;
	
	@FindBy(xpath="//a[normalize-space()='Instructions']")
	private WebElement instructionsBtn;
	
	@FindBy(xpath="//a[normalize-space()='Brute Force']")
	private WebElement bruteForceBtn;
	
	@FindBy(xpath="//a[normalize-space()='Command Injection']")
	private WebElement CIBtn;
	
	@FindBy(xpath="//a[normalize-space()='DVWA Security']")
	private WebElement DVWASecurityBtn;
	
	
	
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyHomePage() {
		return action.isDisplayed(getDriver(), DVWAAssert);
		
	}
	
	public InstructionsPage clickInstructions() {
		action.click(getDriver(), instructionsBtn);
		return new InstructionsPage();
	}
	
	public BruteForcePage clickBruteForce() {
		action.click(getDriver(), bruteForceBtn);
		return new BruteForcePage();
	}
	
	public CommandInjectionPage clickCommandInjection() {
		action.click(getDriver(), CIBtn);
		return new CommandInjectionPage();
	}
	
	public DVWASecurityPage clickDVWASecurity() {
		action.click(getDriver(), DVWASecurityBtn);
		return new DVWASecurityPage();
	}
	
	
	
	

	
}
