package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.dvwa.base.base;
import com.dvwa.pageobjects.LoginPage;
import com.dvwa.utility.Log;
import com.dvwa.pageobjects.BruteForcePage;
import com.dvwa.pageobjects.HomePage;
import com.dvwa.pageobjects.InstructionsPage;
import com.dvwa.dataprovider.DataProviders;

public class BruteForcePageTest extends base {

	LoginPage loginPage;
	HomePage homePage;
	InstructionsPage instructionsPage;
	BruteForcePage bruteForcePage;
	
	@Parameters ("browser")
	@BeforeMethod ( groups = { "Smoke", "Sanity", "Regression"} )
	public void setup(String browser) {
		launchApp(browser); // call this method from BASE CLASS
	}
	@AfterMethod ( groups = { "Smoke", "Sanity", "Regression"} )
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "bruteForce", dataProviderClass = DataProviders.class)
	public void LoginBruteForcePageTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		loginPage= new LoginPage();
		
		homePage = loginPage.clickOnLogin(prop.getProperty("username"), prop.getProperty("password"),homePage); //dataprovider
		Log.info("login success");
		bruteForcePage = homePage.clickBruteForce();
		
		bruteForcePage.bruteForceLogin(uname,pswd);
		boolean result = bruteForcePage.verifyBruteForceLogin();
		Assert.assertTrue(result);
		Log.info("Brute Force Page visible");
		Log.endTestCase("Brute Force Page Test");
	}
}
