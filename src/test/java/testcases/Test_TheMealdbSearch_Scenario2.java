/**
 * The Test_TheMealdbSearch_Scenario2.Java file will perform Search operation with verification of dishes.
 * 
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-08-02
 */

package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.Config;
import pages.PO_TheMealdbSearch;
import utility.LaunchApp;

public class Test_TheMealdbSearch_Scenario2 {
	PO_TheMealdbSearch objTheMealdbSearch=new PO_TheMealdbSearch();
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		LaunchApp la=new LaunchApp();
		la.waitTillPageLoaded(30);
	}

	@Parameters({"searchKeyword","urlnm"})
	@Test
	public void test_verifySearchResult(String searchKeyword, String urlnm)
	{
		//Config.driver.get(urlnm);
		objTheMealdbSearch.load_PO_TheMealdbSearch();
		objTheMealdbSearch.enterSearchText(searchKeyword);
		objTheMealdbSearch.clickOnSearch();

		Assert.assertEquals(Config.driver.getTitle(), "Browse | Meals");	
		Assert.assertEquals(objTheMealdbSearch.getKutsuCurry(), "Katsu Chicken curry");
		Assert.assertEquals(objTheMealdbSearch.getNuttyCurry(), "Nutty Chicken Curry");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		Config.driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}

	}
}
