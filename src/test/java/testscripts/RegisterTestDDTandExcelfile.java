package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class RegisterTestDDTandExcelfile extends Testbase {

	Homepage homeobject;
	RegisterPage registerObj;
	loginPage loginobj;

	@DataProvider(name="Exceldata")
	public Object[][] userregisterdata() throws IOException
	{
		ExcelReader excel= new ExcelReader();

		return excel.getExcelData();
	}


	@Test(dataProvider = "Exceldata")
	public void usercanRegisterSuccussfully(String name, String lName , String email , String password)
	{
		homeobject=new Homepage(driver);
		registerObj=new RegisterPage(driver);

		homeobject.openRegistrationPage();
		registerObj.register(name,lName,email,password);
		Assert.assertEquals("CONTINUE", registerObj.Continuebtn.getText());
		homeobject.logout();
		loginobj = new loginPage(driver);
		homeobject.OpenLoginPage();
		loginobj.logintask(email, password);
		homeobject.logout();

	}




}
