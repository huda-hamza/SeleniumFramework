package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailafriendPage extends Pagebase {

	public EmailafriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FriendEmail")
	WebElement Femail;


	@FindBy(id = "PersonalMessage")
	WebElement PMessage;

	@FindBy(name = "send-email")
	WebElement Sendbtn;

	@FindBy(xpath = "//div[@class='result']")
	public WebElement Successmessage;

	public void sendmail(String Mail1 ,String message) 

	{
		sendkeys(Femail, Mail1);
		sendkeys(PMessage, message);
		clickbtn(Sendbtn);


	}
}
