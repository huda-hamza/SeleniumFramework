package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Pagebase {


	protected WebDriver driver;
	public Select dropdown;
	public Actions action;
	public Pagebase(WebDriver driver)

	{

		this.driver= driver;
		PageFactory.initElements(driver, this);

	}


	//he make it protected static method
	public void clickbtn(WebElement element)
	{

		element.click();
	}

	public void sendkeys(WebElement element , String value)
	{

		element.sendKeys(value);
	}

	// Scroll to the end of page 
	public void Scrolldown()
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	// clear 
	public void Clearmethod(WebElement element)
	{
		element.clear();
	}
}
