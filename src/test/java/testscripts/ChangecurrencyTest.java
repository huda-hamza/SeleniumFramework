package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageobject.Homepage;
import pageobject.Productpages;
import pageobject.SearchPage;

public class ChangecurrencyTest extends Testbase {

	Homepage homeobj ;
	SearchPage Searchobj;
	Productpages productobj;

	@Test(priority = 1)
	public void Testchangecurrency()
	{

		homeobj = new Homepage(driver);
		homeobj.changecurrency();
	}

	@Test(dependsOnMethods = "Testchangecurrency")
	public void serachbyelement()
	{
		Searchobj = new SearchPage(driver);
		Searchobj.search("Mac");
		Searchobj.openproductresult();
		productobj = new Productpages(driver);
		assertTrue(productobj.currencyresult.getText().contains("€1548.00"));

	}

}
