package testscripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonReader;
import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class RegisterTestwithDDTandJson extends Testbase {

	Homepage homeobject;
	RegisterPage registerObj;
	loginPage loginobj;



	JsonReader json;

	@Test
	public void usercanRegisterSuccussfully() throws FileNotFoundException, IOException, ParseException

	{
		homeobject=new Homepage(driver);
		registerObj=new RegisterPage(driver);
		json = new JsonReader();
		json.Jsonread();
		homeobject.openRegistrationPage();
		registerObj.register(json.firstname, json.lname, json.email, json.password);
		Assert.assertEquals("CONTINUE", registerObj.Continuebtn.getText());
		homeobject.logout();
		loginobj = new loginPage(driver);
		homeobject.OpenLoginPage();
		loginobj.logintask(json.email, json.password);
		homeobject.logout();

	}

}
