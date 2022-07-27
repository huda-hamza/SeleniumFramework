package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends Pagebase {

	public MyAccountpage(WebDriver driver) {
		super(driver);

	}

	@FindBy(linkText = "Change password")
	WebElement ChangePwlink;

	@FindBy(id="OldPassword")
	WebElement oldPwtxt;

	@FindBy(id = "NewPassword")
	WebElement newPWtxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmPWtxt;

	@FindBy(css = "button.button-1.change-password-button")
	WebElement changepasswordbtn;

	@FindBy(xpath = "//span[@class='close']")
	 WebElement  closemessage;
	
	@FindBy(css = "p.content")
	public WebElement sucess;


	public void changePW(String OldPW, String NewPW) 
	{

		clickbtn(ChangePwlink);
		sendkeys(oldPwtxt, OldPW);
		sendkeys(newPWtxt, NewPW);
		sendkeys(ConfirmPWtxt, NewPW);
		clickbtn(changepasswordbtn);

	}

	public void closemessage()
	{
		clickbtn(closemessage);
	}
}
