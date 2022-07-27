package testscripts;

import org.testng.annotations.Test;

import pageobject.Homepage;

public class HovermenuTest extends Testbase{
	
	
	Homepage homeobj;
	
	@Test
	public void hovercomputermenu()
	{
		homeobj=new Homepage(driver);
		homeobj.hovercomputermenu();
		
	}

}
