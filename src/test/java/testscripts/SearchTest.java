package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Productpages;
import pageobject.SearchPage;

public class SearchTest extends Testbase {

	String productname="Mac";
	SearchPage Searchobj;
	Productpages productobj;
	
	


	@Test
	public void productSearch()
	{	
		Searchobj =new SearchPage(driver);
		productobj= new Productpages(driver);
		Searchobj.search(productname);
		Searchobj.openproductresult();
		Assert.assertEquals("Apple MacBook Pro 13-inch", productobj.productresult.getText());

	}
}
