package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.AddreviewPage;
import pageobject.Homepage;
import pageobject.Productpages;
import pageobject.RegisterPage;
import pageobject.SearchPage;

public class AddreviewtsTest extends Testbase {

	Homepage homeobj;
	RegisterPage Registerobj;
	SearchPage Searchobj;
	Productpages productobj;
	AddreviewPage reviewobj;

	@Test(priority = 1)
	public void Register()
	{
		homeobj = new Homepage(driver);
		Registerobj = new RegisterPage(driver);
		homeobj.openRegistrationPage();
		Registerobj.register("huda", "Hamza","Hamza3@test.com", "1234567");
		Assert.assertEquals("CONTINUE", Registerobj.Continuebtn.getText());


	}

	@Test(dependsOnMethods = "Register")
	public void Search()
	{
		Searchobj = new SearchPage(driver);
		productobj = new Productpages(driver);
		Searchobj.search("Mac");
		Searchobj.openproductresult();
		productobj.clickonaddreview();
	}

	@Test(dependsOnMethods = "Search")
	public void Addreview()
	{
		reviewobj = new AddreviewPage(driver);
		reviewobj.addreview("Test","Normal");
		assertTrue(reviewobj.Notificationmessage.getText().contains("Product review is successfully added."));
	}

	@Test(dependsOnMethods ={"Addreview"} )
	public void logout() 
	{
		Registerobj.clickonlogout();	
	}

}


