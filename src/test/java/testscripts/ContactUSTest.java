package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.ContactusPage;
import pageobject.Homepage;

public class ContactUSTest extends Testbase {

	Homepage homeobj;
	ContactusPage Contactobj;

	@Test
	public void Contactus()
	{
		homeobj = new Homepage(driver);
		Contactobj = new ContactusPage(driver);
		homeobj.Scrolldown();
		homeobj.openContactus();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		Contactobj.Contucus("Huda", "hoda@test.com", "HHHHH");
		Assert.assertTrue(Contactobj.Successmessage.getText().contains("successfully"));

	}

}
