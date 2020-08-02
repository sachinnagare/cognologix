/**
 * Design Pattern used - Page Object Model (POM) by using Page Factory. 
 * The PO_TheMealdbSearch.Java file find the all the Locators available on the page. All required methods are written here.
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-08-01
 */

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import config.Config;

public class PO_TheMealdbSearch {


	@FindBy(how = How.XPATH, using="//input[@placeholder='Search for a Meal...']")
	static WebElement we_searchBox;

	@FindBy(how = How.XPATH, using="//button[@type='submit']")
	WebElement we_SearchButton;

	@FindBy(how=How.LINK_TEXT, using = "Katsu Chicken curry")
	WebElement we_KatsuCurry;

	@FindBy(how=How.LINK_TEXT, using = "Nutty Chicken Curry")
	WebElement we_NuttyCurry;

	public void load_PO_TheMealdbSearch()
	{
		PageFactory.initElements(Config.driver, this);
	}

	public void enterSearchText(String searchKeyword) {
		we_searchBox.sendKeys(searchKeyword);
	}

	public String getKutsuCurry()
	{
		String txtKutsuCurry=we_KatsuCurry.getText();
		return txtKutsuCurry;
	}

	public String getNuttyCurry()
	{
		String txtNuttyCurry=we_NuttyCurry.getText();
		return txtNuttyCurry;
	}
	public void clickOnSearch()
	{
		we_SearchButton.click();
	}

}
