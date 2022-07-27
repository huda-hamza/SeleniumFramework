package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Productpages;
import pageobject.SearchPage;

public class SearchusingAutocomplete extends Testbase {

	SearchPage searchobj;
	Productpages productobj;

	@Test
	public void testSearchAutocomplete()
	{

		searchobj=new SearchPage(driver);
		productobj= new Productpages(driver);
		searchobj.SerachusingAutocomplete("Mac");
		Assert.assertEquals("Apple MacBook Pro 13-inch", productobj.productresult.getText());

	}


}


