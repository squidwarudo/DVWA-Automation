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
import com.dvwa.pageobjects.CommandInjectionPage;
import com.dvwa.pageobjects.DVWASecurityPage;
import com.dvwa.pageobjects.HomePage;
import com.dvwa.pageobjects.InstructionsPage;
import com.dvwa.dataprovider.DataProviders;

public class HomePageTest extends base {

	 //first value is PAGE OBJECT. 2nd is param para sa page na to
		LoginPage loginPage;
		HomePage homePage;
		InstructionsPage instructionsPage;
		BruteForcePage bruteForcePage;
		CommandInjectionPage commandInjectionPage;
		DVWASecurityPage dvwaSecurityPage;
		
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
			boolean result = instructionsPage.verifyInstructionsPage();
			Assert.assertTrue(result);
			Log.info("Instructions Page visible");
			Log.endTestCase("Instructions Page Test");
		}
		
		@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
		public void clickBruteForcePageTest(String uname, String pswd) throws Throwable {
			Log.startTestCase("loginTest");
			loginPage= new LoginPage();
			
			homePage = loginPage.clickOnLogin(uname, pswd, homePage); //dataprovider
			Log.info("login success");
			bruteForcePage = homePage.clickBruteForce();
			boolean result = bruteForcePage.verifyBruteForcePage();
			Assert.assertTrue(result);
			Log.info("Brute Force Page visible");
			Log.endTestCase("Brute Force Page Test");
		}
		
		@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
		public void clickCommandInjectionPageTest(String uname, String pswd) throws Throwable {
			Log.startTestCase("loginTest");
			loginPage= new LoginPage();
			
			homePage = loginPage.clickOnLogin(uname, pswd, homePage); //dataprovider
			Log.info("login success");
			commandInjectionPage = homePage.clickCommandInjection();
			boolean result = commandInjectionPage.verifyCommandInjectionPage();
			Assert.assertTrue(result);
			Log.info("Command Injection Page visible");
			Log.endTestCase("Brute Force Page Test");
		}
		
		@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
		public void clickDVWASecurityPageTest(String uname, String pswd) throws Throwable {
			Log.startTestCase("loginTest");
			loginPage= new LoginPage();
			
			homePage = loginPage.clickOnLogin(uname, pswd, homePage); //dataprovider
			Log.info("login success");
			dvwaSecurityPage = homePage.clickDVWASecurity();
			boolean result = dvwaSecurityPage.verifyDVWASecurityPage();
			Assert.assertTrue(result);
			Log.info("DVWA Page visible");
			Log.endTestCase("DVWA Page Test");
		}
		
		
}
