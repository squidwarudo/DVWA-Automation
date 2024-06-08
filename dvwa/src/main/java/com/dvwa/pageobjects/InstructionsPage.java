package com.dvwa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dvwa.actiondriver.Action;
import com.dvwa.base.base;

public class InstructionsPage extends base {

	Action action = new Action();

	@FindBy(xpath = "//a[normalize-space()='Read Me']")
	private WebElement InstructionsAssert;

	@FindBy(xpath = "//p[contains(text(),'Damn Vulnerable Web Application is damn vulnerable')]//a[normalize-space()='XAMPP']")
	private WebElement XAMPPLink;

	@FindBy(xpath = "//a[normalize-space()='Apache Friends']")
	private WebElement XAMPPAssert;

	public InstructionsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean verifyInstructionsPage() {

		return action.isDisplayed(getDriver(), InstructionsAssert);

	}

	public void clickXAMPP() {
		action.click(getDriver(), XAMPPLink);
	}

	public boolean verifyXAMPPLink() {

		return action.isDisplayed(getDriver(), XAMPPAssert);

	}

}
