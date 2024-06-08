package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.dvwa.base.base;
import com.dvwa.pageobjects.LoginPage;
import com.dvwa.utility.Log;
import com.dvwa.pageobjects.HomePage;
import com.dvwa.dataprovider.DataProviders;

public class LoginPageTest extends base {

	 //first value is PAGE OBJECT. 2nd is param para sa page na to
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters ("browser")
	@BeforeMethod ( groups = { "Smoke", "Sanity", "Regression"} )
	public void setup(String browser) {
		launchApp(browser); // call this method from BASE CLASS
	}
	@AfterMethod ( groups = { "Smoke", "Sanity", "Regression"} )
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws InterruptedException {
		Log.startTestCase("loginTest");
		loginPage= new LoginPage();
		
		homePage = loginPage.clickOnLogin(uname, pswd, homePage); //dataprovider
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue(result);
		Log.info("login success");
		Log.endTestCase("loginTest");
	}
	
}
