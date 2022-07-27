package testscripts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageobject.AddtoCartPage;
import pageobject.CheckoutPage;
import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.SearchPage;

public class RegisterusercheckoutproductTest extends Testbase{


	RegisterPage registerobj;
	Homepage homeobj;
	SearchPage searchobj;
	AddtoCartPage Addtocartobj;
	CheckoutPage checkoutobj;

	@Test(priority = '1')
	public void register()
	{
		registerobj= new RegisterPage(driver);
		homeobj=new Homepage(driver);
		homeobj.openRegistrationPage();
		registerobj.register("Huda", "hamza", "Hoda.hamza14@google.com", "1234567");
		assertTrue(registerobj.message.getText().contains("Your registration completed"));

	}

	@Test(dependsOnMethods =  "register")
	public void searchmethod()
	{
		searchobj=new SearchPage(driver);
		Addtocartobj = new AddtoCartPage(driver);
		searchobj.search("Mac");
		searchobj.openproductresult();
		Addtocartobj.clickonaddcart();
		Addtocartobj.checkout();	
		

	}
	
	@Test(dependsOnMethods = "searchmethod")
	public void checkout() 
	
	{
		checkoutobj= new CheckoutPage(driver);
		checkoutobj.billingaddress("Egypt", "cairo", "6 of october", "123456", "12345678");
		checkoutobj.shipping();
		checkoutobj.paymentmethhod();
		checkoutobj.paymentinfo();
		checkoutobj.confirmorder();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutobj.conbtn));
		assertTrue(checkoutobj.successmessage.getText().contains("Your order has been successfully processed!"));
	}
	
	@Test(enabled = false)
	public void logout() 
	{

		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("document.getElementsByTagName('a')[1].click();");

	}

}
