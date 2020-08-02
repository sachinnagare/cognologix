/**
 * The Test_TheMealdb.Java file will perform operation on Avacado fruit and parameters are passed from textng.xml file
 * 
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-08-1
 */

package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import config.Config;
import pages.PO_TheMealdbSearch;
import pages.PO_ThemealdbHome;
import utility.LaunchApp;

public class Test_TheMealdb {
	PO_ThemealdbHome objThermalDB=new PO_ThemealdbHome();
	PO_TheMealdbSearch objTheMealdbSearch=new PO_TheMealdbSearch();
	private StringBuffer verificationErrors = new StringBuffer();


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		LaunchApp la=new LaunchApp();
		la.waitTillPageLoaded(30);
	}

	@Test (priority=1)
	public void test_verifyAvocadoExists()
	{
		objThermalDB.load_ThemealdbHomePage();	
		Assert.assertEquals(Config.driver.getTitle(), "TheMealDB.com");
		String text=	objThermalDB.get_Avacado_Text();
		System.out.println(objThermalDB.get_Avacado_Text());	
		Assert.assertEquals(objThermalDB.get_Avacado_Text(), "Avocado");

	}

	@Test(priority=2)
	public void test_CajunSpicedfishExist()
	{	
		objThermalDB.load_ThemealdbHomePage();
		objThermalDB.clickOnAvacado();
		Assert.assertEquals(Config.driver.getTitle(), "Avocado | TheMealDB");
		Assert.assertEquals(objThermalDB.get_Avacado_Description(), "Desription"); 

	}

	@Test(priority=3)
	public void test_CajunSpicedfishInstructions()
	{
		objThermalDB.load_ThemealdbHomePage();
		//	objThermalDB.clickOnAvacado();
		objThermalDB.clickOnCajunSpicedFish();
		Assert.assertEquals(Config.driver.getTitle(), "Cajun spiced fish tacos | TheMealDB"); 
		Assert.assertEquals(Config.driver.findElement(By.xpath("//section[@id='feature']/div/div/h2")).getText(), "Instructions");

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
