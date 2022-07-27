package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class comparepage extends Pagebase{

	public comparepage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "product comparison")
	WebElement comparisonpage;

	@FindBy(tagName = "tr")
	List<WebElement>	rows;

	@FindBy(tagName = "td")
	List<WebElement>	cols;

	@FindBy(xpath = "//a[@class='clear-list']")
	WebElement clearbtn;
	
	
	
	@FindBy(xpath = "//div[@class='no-data']")
	public WebElement nodatamessage;

	public void opencomparepage()
	{
		clickbtn(comparisonpage);
	}

	public void printdata()
	{
		for (WebElement row : rows) 
		{
			System.out.println(row.getText() + "\t");
			for (WebElement col : cols) 
			{
				System.out.println(col.getText()+ "\t");
			}
			break;
		}
		
	}

	public void cleardata()
	{
		clickbtn(clearbtn);
	}
}
