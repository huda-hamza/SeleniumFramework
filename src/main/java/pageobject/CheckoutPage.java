package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends Pagebase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement citytxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement Address1txt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipcodetxt;
	
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phonetxt;
	
	@FindBy(xpath = "//button[@class='button-1 new-address-next-step-button']")
	WebElement continuebtn;
	
	
	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement countrylst;
	
	@FindBy(id = "shippingoption_1")
	WebElement nextairradio;
	
	@FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
	WebElement connbtn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement checkmoneyradio;
	
	@FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
	WebElement savebtn;
	
	@FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
	WebElement COtBTn;
	
	@FindBy(xpath = "//button[@class='button-1 confirm-order-next-step-button']")
	WebElement Confirmbtn;
	
	@FindBy(xpath = "//div[@class='title']")
	public WebElement successmessage;
	
	@FindBy(xpath = "//button[@class='button-1 order-completed-continue-button']")
	public WebElement conbtn;
	
	Select selectt = new Select(countrylst);
	
	public void billingaddress(String Country,String City,String address1 ,String Zip,String phone)
	{
		selectt.selectByVisibleText(Country);
		sendkeys(citytxt, City);
		sendkeys(Address1txt, address1);
		sendkeys(zipcodetxt, Zip);
		sendkeys(phonetxt, phone);
		clickbtn(continuebtn);
	}
	
	public void shipping()
	{
		clickbtn(nextairradio);
		clickbtn(connbtn);
	}
	
	public void paymentmethhod()
	{
		clickbtn(checkmoneyradio);
		clickbtn(savebtn);
	}
	
	public void paymentinfo() 
	{
		clickbtn(COtBTn);
	}
	
	public void confirmorder()
	{
		clickbtn(Confirmbtn);
	}
	
	
}
