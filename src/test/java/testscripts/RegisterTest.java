package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class RegisterTest extends Testbase {

	Homepage homeobject;
	RegisterPage registerObj;
	loginPage loginobj;

	@Test
	public void usercanRegisterSuccussfully()
	{
		homeobject=new Homepage(driver);
		registerObj=new RegisterPage(driver);

		homeobject.openRegistrationPage();
		registerObj.register("Huda", "Hamza", "hoda.hamza3@gmail.com", "12345678");
		Assert.assertEquals("CONTINUE", registerObj.Continuebtn.getText());
	}

	@Test(dependsOnMethods = "usercanRegisterSuccussfully")
	public void logoutregistereduser()
	{
		homeobject.logout();

	}


	@Test(dependsOnMethods = "logoutregistereduser")
	public void usercanlogin()
	{
		loginobj = new loginPage(driver);
		homeobject.OpenLoginPage();
		loginobj.logintask("hoda.hamza3@gmail.com", "12345678");

	}

}
