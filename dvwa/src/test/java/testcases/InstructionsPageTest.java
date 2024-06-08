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
import com.dvwa.pageobjects.InstructionsPage;
import com.dvwa.dataprovider.DataProviders;

public class InstructionsPageTest extends base{

	LoginPage loginPage;
	HomePage homePage;
	InstructionsPage instructionsPage;
	
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
	public void clickInstructionsPageTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("loginTest");
		loginPage= new LoginPage();
		
		homePage = loginPage.clickOnLogin(uname, pswd, homePage); //dataprovider
		Log.info("login success");
		instructionsPage = homePage.clickInstructions();
		instructionsPage.clickXAMPP();
		boolean result = instructionsPage.verifyXAMPPLink();
		Assert.assertTrue(result);
		Log.info("Instructions Page visible");
		Log.endTestCase("Instructions Page Test");
	}

	
	
	
}
