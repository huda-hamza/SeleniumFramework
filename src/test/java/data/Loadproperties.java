package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Loadproperties {


	public static Properties userdata=
			loadproperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");

	public static Properties loadproperties(String path)
	{

		Properties pro = new Properties();

		try {
			FileInputStream input = new FileInputStream(path);

			pro.load(input);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return pro;
	}

}
