package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class RegisterTestwithJavafaker extends Testbase {

	Homepage homeobject;
	RegisterPage registerObj;
	loginPage loginobj;
	Faker fakedata= new Faker();

	String fname = fakedata.name().firstName();
	String lname = fakedata.name().lastName();
	String email =fakedata.internet().emailAddress();
	String password = fakedata.number().digits(8);

	@Test
	public void usercanRegisterSuccussfully()
	{
		homeobject=new Homepage(driver);
		registerObj=new RegisterPage(driver);

		homeobject.openRegistrationPage();
		registerObj.register(fname,lname,email,password);
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
