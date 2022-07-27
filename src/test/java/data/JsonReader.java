package data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonReader {

	public String firstname,lname,email,password;


	@Test
	public void Jsonread() throws FileNotFoundException, IOException, ParseException
	{

		JSONParser parser = new JSONParser();
		org.json.simple.JSONArray jarray= 
				(org.json.simple.JSONArray)parser.parse(new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\data\\Testdata.json"));

		for(Object jsonobj: jarray)
		{
			JSONObject person = (JSONObject)jsonobj;


			firstname = (String) person.get("firstname");
			System.out.println(firstname);

			lname=(String) person.get("Secondname");
			System.out.println(lname);

			email = (String) person.get("email");
			System.out.println(email);

			password = (String) person.get("password");
			System.out.println(password);


		}
	}

}
