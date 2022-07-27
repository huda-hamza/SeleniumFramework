package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageobject.Productpages;
import pageobject.SearchPage;
import pageobject.comparepage;

public class ComparePageTest extends Testbase {


	SearchPage  Searchobj;
	Productpages productobj;
	comparepage compareobj;

	@Test
	public void Compareitems()
	{
		Searchobj = new SearchPage(driver);
		productobj= new Productpages(driver);
		compareobj= new comparepage(driver);

		Searchobj.search("Mac");
		Searchobj.openproductresult();	
		productobj.Addtocomparepage();
		//must add assert
		Searchobj.search("Asus");
		Searchobj.openproductresult();
		productobj.Addtocomparepage();	
		//must add assert
		compareobj.opencomparepage();
		compareobj.printdata();
	}

	@Test
	public void cleardata()
	{
		compareobj.cleardata();
		assertTrue(compareobj.nodatamessage.getText().contains("You have no items to compare."));

	}


}
