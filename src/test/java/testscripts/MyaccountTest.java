package testscripts;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.MyAccountpage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class MyaccountTest extends Testbase {

	RegisterPage registerobj;
	Homepage homeobj;
	MyAccountpage myaccountobj;
	loginPage loginobj;

	@Test(priority = 1)
	public void register()

	{
		registerobj = new RegisterPage(driver);
		homeobj = new Homepage(driver);
		homeobj.openRegistrationPage();
		registerobj.register("huda", "hamza", "hoda11@hamza.com", "123456789");//change by variable and configure it at first 
		assertTrue(registerobj.Continuebtn.getText().contains("CONTINUE"));

	}

	@Test(dependsOnMethods = "register")
	public void changepw() 
	{
		registerobj.openmyaccountpage();
		myaccountobj = new MyAccountpage(driver);
		myaccountobj.changePW("123456789", "1234567");
		assertTrue(myaccountobj.sucess.getText().toLowerCase().contains("changed"));
		myaccountobj.closemessage();

	}

	@Test(dependsOnMethods = "changepw")
	public void logout() 
	{

		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("document.getElementsByTagName('a')[1].click();");

	}

	@Test(dependsOnMethods = "logout")
	public void login()
	{
		loginobj=new loginPage(driver);
		homeobj.OpenLoginPage();
		loginobj.logintask("hoda11@hamza.com","1234567");
		Assert.assertTrue(registerobj.myaccountlink.isDisplayed());
	}

}
