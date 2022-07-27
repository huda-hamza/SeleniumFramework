package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactusPage extends Pagebase {

	public ContactusPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FullName")
	WebElement YName;

	@FindBy(id = "Email")
	WebElement YEmail;

	@FindBy(id = "Enquiry")
	WebElement Enquiry;

	@FindBy(name = "send-email")
	WebElement Btn;
	
	@FindBy(css = "div.result")
	public WebElement Successmessage;

	public void Contucus(String name , String email,String EQ) 

	{
		sendkeys(YName, name);
		sendkeys(YEmail, email);
		sendkeys(Enquiry, EQ);
		clickbtn(Btn);


	}
}
