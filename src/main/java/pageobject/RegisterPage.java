package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Pagebase {


	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement genderchoice;

	@FindBy(id = "FirstName")
	WebElement FName;

	@FindBy(id = "LastName")
	WebElement LName;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement PW;

	@FindBy(id = "ConfirmPassword")
	WebElement ConPW;

	@FindBy(id = "register-button")
	WebElement Registerbtn;

	@FindBy(css = "a.button-1.register-continue-button")
	public WebElement Continuebtn;
	
	@FindBy(xpath = "//div[@class='result']")
	public WebElement message;

	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutlink;

	@FindBy(linkText = "My account")
	public WebElement myaccountlink;

	public void register(String name1,String name2,String Email,String Pass)
	{
		clickbtn(genderchoice);
		sendkeys(FName, name1);
		sendkeys(LName, name2);
		sendkeys(email, Email);
		sendkeys(PW, Pass);
		sendkeys(ConPW, Pass);
		clickbtn(Registerbtn);

	}
	public void clickonlogout()
	{
		clickbtn(logoutlink);
	}
	public void openmyaccountpage()
	{
		clickbtn(myaccountlink);
	}
}
