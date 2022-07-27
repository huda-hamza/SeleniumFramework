package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pageobject.AddtoCartPage;
import pageobject.SearchPage;

public class AddtoCartTest extends Testbase {



	AddtoCartPage Cartobj;
	SearchPage searchobj;

	@Test
	public void AddtocartFun()
	{
		Cartobj=new AddtoCartPage(driver);
		searchobj =new SearchPage(driver);

		searchobj.search("MAC");
		searchobj.openproductresult();
		Cartobj.clickonaddcart();
		Cartobj.changeQty("4");
		assertTrue(Cartobj.totalarea.getText().contains("$7,200.00"));
		Cartobj.removecart();
		assertTrue(Cartobj.emptymessage.getText().contains("Your Shopping Cart is empty!"));






	}
}
