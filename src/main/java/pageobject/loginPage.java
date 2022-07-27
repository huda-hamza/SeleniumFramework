package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends Pagebase {

	public loginPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id = "Email")
	WebElement Email;

	@FindBy(id = "Password")
	WebElement Pw; 

	@FindBy(css = "button.button-1.login-button")
	WebElement loginbtn;


	public void logintask(String email, String Pass ) 
	{

		sendkeys(Email, email);
		sendkeys(Pw, Pass);
		clickbtn(loginbtn);
	}
}
