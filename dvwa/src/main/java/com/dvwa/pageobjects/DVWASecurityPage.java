package com.dvwa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dvwa.actiondriver.Action;
import com.dvwa.base.base;
public class DVWASecurityPage extends base {

	Action action = new Action();
	
	@FindBy(xpath="//h1[normalize-space()='DVWA Security']")
	private WebElement DVWASecurityAssert;
	
	@FindBy(xpath="//select[@name='security']")
	private WebElement SelectDVWASecurity;
	
	@FindBy(xpath="//input[@name='seclev_submit']")
	private WebElement SubmitSelect;
	
	@FindBy(xpath="//em[normalize-space()='low']")
	private WebElement LowAssert;
	
	
	
	
	public DVWASecurityPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean verifyDVWASecurityPage() {
		return action.isDisplayed(getDriver(), DVWASecurityAssert);
	}
	
	public void selectDVWASecurityLevelLow() {
		action.selectByIndex(SelectDVWASecurity, 0);
		action.click(getDriver(), SubmitSelect);
	}
	
	
	public boolean verifySecurityLevelLow() {
		return action.isDisplayed(getDriver(), LowAssert);
	}
	
}
