package testscripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class LoginTest extends Testbase {

	Homepage homeobj;
	RegisterPage regesterobj;
	loginPage loginobj;

	@Test(priority = 1)
	public void Registertask()

	{
		homeobj = new Homepage(driver);
		homeobj.openRegistrationPage();
		regesterobj=new RegisterPage(driver);
		regesterobj.register("huda", "hamza", "hoda.hamza3@gamil.com", "12345678");
		Assert.assertTrue(regesterobj.Continuebtn.getText().toLowerCase().contains("continue"));

	}


	@Test(dependsOnMethods ={"Registertask"} )
	public void logout() 
	{
		regesterobj.clickonlogout();	
	}

	@Test(dependsOnMethods = "logout")
	public void logintask()
	{
		homeobj.OpenLoginPage();
		loginobj=new loginPage(driver);
		loginobj.logintask("hoda.hamza3@gamil.com", "12345678");
		Assert.assertTrue(regesterobj.myaccountlink.isDisplayed());
	}


}
