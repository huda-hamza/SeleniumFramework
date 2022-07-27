package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddreviewPage extends Pagebase{

	public AddreviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement Reviewtitle;

	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewtxt;

	@FindBy(id = "addproductrating_3")
	WebElement Notbadreview;

	@FindBy(name = "add-review")
	WebElement Submitbtn;
	
	@FindBy(css = "div.result")
	public WebElement Notificationmessage;

	public void addreview(String title ,String review )

	{
		sendkeys(Reviewtitle, title);
		sendkeys(reviewtxt, review);
		clickbtn(Notbadreview);
		clickbtn(Submitbtn);
	}

}
