package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.Loadproperties;
import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class RegisterTestTDDandpropertiesFile extends Testbase {

	Homepage homeobject;
	RegisterPage registerObj;
	loginPage loginobj;
	String fname=Loadproperties.userdata.getProperty("Fname");
	String lname=Loadproperties.userdata.getProperty("Sname");
	String email=Loadproperties.userdata.getProperty("Email");
	String password=Loadproperties.userdata.getProperty("Password");

	@Test
	public void usercanRegisterSuccussfully( )
	{
		homeobject=new Homepage(driver);
		registerObj=new RegisterPage(driver);

		homeobject.openRegistrationPage();
		registerObj.register(fname, lname,email,password);
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
		loginobj.logintask(email, password);

	}

}
