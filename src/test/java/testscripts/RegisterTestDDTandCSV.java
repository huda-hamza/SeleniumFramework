package testscripts;


import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import pageobject.Homepage;
import pageobject.RegisterPage;
import pageobject.loginPage;

public class RegisterTestDDTandCSV extends Testbase {

	Homepage homeobject;
	RegisterPage registerObj;
	loginPage loginobj;
	CSVReader reader; 
	

	@Test
	public void usercanRegisterSuccussfully() throws CsvValidationException, IOException
	{
		String Path = System.getProperty("user.dir")+"\\src\\test\\java\\data\\Testdata.csv";
		reader = new CSVReader(new FileReader(Path));

		String[] csvCell;

		while((csvCell=reader.readNext())!= null)
		{
			String Firstname = csvCell[0];
			String lName = csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			homeobject=new Homepage(driver);
			registerObj=new RegisterPage(driver);
			homeobject.openRegistrationPage();
			registerObj.register(Firstname, lName, email, password);
			Assert.assertEquals("CONTINUE", registerObj.Continuebtn.getText());
			homeobject.logout();
			loginobj = new loginPage(driver);
			homeobject.OpenLoginPage();
			loginobj.logintask(email, password);
			homeobject.logout();

		}
	}
}

