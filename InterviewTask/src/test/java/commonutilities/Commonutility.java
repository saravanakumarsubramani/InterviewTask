package commonutilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Commonutility {

	public static Properties Properties;
	public static WebDriver driver;

	public Properties loadProperty()   {

		FileInputStream stream = null;
		try {
			stream = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}

		Properties = new Properties();
		try {
			Properties.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Properties;

	}

	@BeforeSuite
	public void lanchBrowser()   {

		loadProperty();

		String browser = Properties.getProperty("browser");
		String driverLocation = Properties.getProperty("DriverLocation");	

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",driverLocation);
			driver = new ChromeDriver();
		} if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",driverLocation);

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}

}


