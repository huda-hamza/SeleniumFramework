package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class Homepage extends Pagebase {


	public Homepage(WebDriver driver) {
		super(driver);
		action = new Actions(driver);

	}

	private By logout = By.linkText("Log out"); // pageobjectmodel




	@FindBy(linkText = "Register")   // pagefactory
	WebElement Registerbtn;

	@FindBy(linkText = "Log in")
	WebElement loginbtn;

	@FindBy(linkText = "Contact us")
	WebElement Contus;

	@FindBy(id = "customerCurrency")
	WebElement Currency;


	@FindBy(xpath = "//a[text()='Computers ']")
	WebElement Computermenu;

	@FindBy(xpath = "//a[text()='Notebooks ']")
	WebElement notebooksubmenu;

	public void openRegistrationPage()
	{
		clickbtn(Registerbtn);
	}

	public void OpenLoginPage()
	{
		clickbtn(loginbtn);
	}

	public void openContactus()
	{
		clickbtn(Contus);
	}

	public void changecurrency()

	{
		dropdown = new Select(Currency);
		dropdown.selectByVisibleText("Euro");
	}
	public void hovercomputermenu()
	{

		action.moveToElement(Computermenu)
		.moveToElement(notebooksubmenu)
		.click().build().perform();

	}

	public void logout()
	{

		driver.findElement(logout).click();

	}


}





