package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddtoCartPage extends Pagebase{

	public AddtoCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "add-to-cart-button-4")
	WebElement Addtocratbtn;


	@FindBy(linkText = "shopping cart")
	WebElement Shoppingcartlink;
	
	@FindBy(xpath = "//input[@class='qty-input']")
	WebElement QtyTXT;
	
	@FindBy(id = "updatecart")
	WebElement updateshoppingbtn;
	
	@FindBy(xpath = "//span[@class='product-subtotal']")
	public WebElement totalarea;
	
	@FindBy(name = "updatecart")
	WebElement removebtn;
	
	@FindBy(xpath = "//div[@class='no-data']")
	public WebElement emptymessage;
	
	
	@FindBy(id = "termsofservice")
	WebElement termscheckbox;
	
	@FindBy(id = "checkout")
	WebElement checkoutbtn;

	public void clickonaddcart() 
	{
		clickbtn(Addtocratbtn);	
		clickbtn(Shoppingcartlink);

	}
	
	public void changeQty(String Qty)
	{
		Clearmethod(QtyTXT);
		sendkeys(QtyTXT, Qty);
		clickbtn(updateshoppingbtn);
	}
	public void removecart() 
	{
		clickbtn(removebtn);
	}
	
	public void checkout()
	{
		clickbtn(termscheckbox);
		clickbtn(checkoutbtn);
	}
}
