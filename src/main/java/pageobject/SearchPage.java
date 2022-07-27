package pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Pagebase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "small-searchterms")
	WebElement Searchtxt;

	@FindBy(xpath = "//button[@class='button-1 search-box-button']")
	WebElement Searchbutton;

	@FindBy(css = "h2.product-title")
	WebElement productresult;
	

	@FindBy(id = "ui-id-1")
	List<WebElement> listofresult;


	public void search(String data) 
	{
		sendkeys(Searchtxt, data);
		clickbtn(Searchbutton);

	}

	public void openproductresult()
	{
		clickbtn(productresult);
	}
	public void SerachusingAutocomplete(String data) 
	{	
		sendkeys(Searchtxt, data);
		driver.manage().timeouts().implicitlyWait(2500, TimeUnit.SECONDS);
		listofresult.get(0).click();// when change index if we serach with data have more choice

	}
	
}
