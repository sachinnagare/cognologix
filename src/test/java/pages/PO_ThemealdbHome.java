/**
 * Design Pattern used - Page Object Model (POM) by using Page Factory. 
 * The PO_ThemealdbHome.Java file find the all the Locators available on the page. All required methods are written here.
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-08-01
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import config.Config;

public class PO_ThemealdbHome {

	@FindBy(how = How.XPATH, using = "//img[@src='/images/ingredients/Avocado.png']")
	static WebElement we_Avacado;


	@FindBy(how = How.XPATH, using = "//figcaption[contains(text(),'Avocado')]")
	static WebElement we_Avacado1;


	@FindBy (how = How.XPATH, using = "//section[@id='feature']/div/div/h2")
	WebElement we_Description;

	@FindBy(how=How.XPATH, using="//figcaption[contains(text(),'Cajun spiced fish tacos')]")
	WebElement we_CajunFish;

	public void load_ThemealdbHomePage()
	{
		PageFactory.initElements(Config.driver, this);
	}

	public static String get_Avacado_Text()
	{
		String titleText= we_Avacado1.getText();
		return titleText;
	}
	public void clickOnAvacado()
	{
		we_Avacado.click();
	}

	public String get_Avacado_Description()
	{
		String getAvacadoText=we_Description.getText();
		System.out.println(getAvacadoText);
		return getAvacadoText;

	}

	public void clickOnCajunSpicedFish()
	{
		we_CajunFish.click();
	}
}