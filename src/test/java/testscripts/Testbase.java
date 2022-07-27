package testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Testbase {

	public static WebDriver driver;
	@Parameters({"browser"})
	@BeforeSuite
	public void Setup(@Optional("chrome")String browsertype)
	{
		if(browsertype.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browsertype.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		else if (browsertype.equalsIgnoreCase("headless"))
		{

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir")+"\\drivers\\phantomjs.exe");
			String[] phantomjsArg = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomjsArg);
			driver = new PhantomJSDriver(caps);
		}

		else if (browsertype.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir")+"\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@AfterSuite
	public void teardown()
	{
		driver.quit();	
	}
}
