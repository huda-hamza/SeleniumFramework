package testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class RegisterTestwithDDTandDataprovider extends Testbase {

	Homepage homeobject;
	RegisterPage registerObj;
	loginPage loginobj;


	@DataProvider(name = "userdata")	
	public Object[][]testdata()
	{

		return new Object[][]
				{
			{"moataz","Nabil","axy5@abc.com","123456"},
			{"Huda","Hamza","axyy5@abc.com","12345678"}
				};
	}

	@Test( dataProvider = "userdata")
	public void usercanRegisterSuccussfully( String fname , String SName , String email, String Password)
	{
		homeobject=new Homepage(driver);
		registerObj=new RegisterPage(driver);

		homeobject.openRegistrationPage();
		registerObj.register(fname, SName, email, Password);
		Assert.assertEquals("CONTINUE", registerObj.Continuebtn.getText());
		homeobject.logout();
		loginobj = new loginPage(driver);
		homeobject.OpenLoginPage();
		loginobj.logintask(email, Password);
		homeobject.logout();
	}



}
