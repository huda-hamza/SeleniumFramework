package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.EmailafriendPage;
import pageobject.Homepage;
import pageobject.Productpages;
import pageobject.RegisterPage;
import pageobject.SearchPage;

public class EmailaFriendTest extends Testbase {


	Homepage homobj;
	RegisterPage Regobj;
	SearchPage Searchobj;
	Productpages proobj;
	EmailafriendPage Emailobj;

	@Test(priority = 1)
	public void register()
	{

		homobj = new Homepage(driver);
		Regobj = new RegisterPage(driver);
		homobj.openRegistrationPage();
		Regobj.register("huda", "Hamza", "hoda43@test.com", "1234567");

		assertTrue(Regobj.Continuebtn.getText().toLowerCase().contains("continue"));
	}

	@Test(dependsOnMethods = "register")
	public void Searchonelement()
	{
		Searchobj = new SearchPage(driver);
		proobj = new Productpages(driver);
		Searchobj.search("Mac");
		Searchobj.openproductresult();
		assertTrue(proobj.productresult.getText().toLowerCase().contains("macbook"));
	}

	@Test(dependsOnMethods = "Searchonelement")
	public void openemailpage() throws InterruptedException
	{
		Emailobj=new EmailafriendPage(driver);
		proobj.openEmailpage();
		Emailobj.sendmail("test@h.com", "plplpl");
		Assert.assertTrue(Emailobj.Successmessage.getText().contains("Your message has been sent"));
	}
}
