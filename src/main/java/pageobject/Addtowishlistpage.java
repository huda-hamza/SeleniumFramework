package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Addtowishlistpage extends Pagebase{

	public Addtowishlistpage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[text()='wishlist']")
	WebElement wishbtn;
	
	@FindBy(name = "updatecart")
	WebElement removefromwishlistbtn;
	
	
	@FindBy(xpath = "//div[@class='no-data']")
	public WebElement emptymesage;
	
	@FindBy(xpath = "//div[@class='page-title']")
	public WebElement wishlistheader;
	
	public void clickonwishlistNotification()
	{
		clickbtn(wishbtn);
	}
	
	public void removefromwishlist()
	{
		
		clickbtn(removefromwishlistbtn);
	}

}
