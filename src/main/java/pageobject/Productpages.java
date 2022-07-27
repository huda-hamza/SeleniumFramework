package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Productpages extends Pagebase {

	public Productpages(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.product-name")
	public WebElement productresult;

	@FindBy(xpath = "//button[@class='button-2 email-a-friend-button']")
	WebElement Emailbutton;

	@FindBy(id = "price-value-4")
	public WebElement currencyresult;
	
	@FindBy(linkText = "Add your review")
	WebElement Addreviews;

	 @FindBy(id = "add-to-wishlist-button-4")
	 WebElement addtowishbtn;
	 
	 @FindBy(xpath = "//button[@class='button-2 add-to-compare-list-button']")
	 WebElement Addtocomparebtn;


	public void openEmailpage()
	{

		clickbtn(Emailbutton);
	}
	
	public void clickonaddreview()
	{
		
		clickbtn(Addreviews);
	}
	
	public void Addtowish()
	{
		clickbtn(addtowishbtn);
	}
	public void Addtocomparepage()
	{
		clickbtn(Addtocomparebtn);
	}

}
