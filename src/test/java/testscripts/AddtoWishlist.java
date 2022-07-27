package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageobject.Addtowishlistpage;
import pageobject.Productpages;
import pageobject.SearchPage;

public class AddtoWishlist extends Testbase {


	SearchPage searchobj;
	Productpages productobj;
	Addtowishlistpage wishobj;

	@Test(priority = 1)
	public void searchmethod()
	{
		searchobj= new SearchPage(driver);
		searchobj.search("Mac");
		searchobj.openproductresult();
	}

	@Test(dependsOnMethods = "searchmethod")
	public void Addtowishlistmethod()
	{
		productobj= new Productpages(driver);	
		productobj.Addtowish();
		wishobj=new Addtowishlistpage(driver);
		wishobj.clickonwishlistNotification();
		assertTrue(wishobj.wishlistheader.getText().contains("Wishlist"));
	}

	@Test(dependsOnMethods = "Addtowishlistmethod")
	public void removefromwishlist()
	{
		wishobj.removefromwishlist();
		assertTrue(wishobj.emptymesage.getText().contains("empty"));
	}

}
