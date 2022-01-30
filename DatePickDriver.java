package datepicker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickDriver {
	
	WebDriver driver;
	FileInputStream file;
	public static Properties pr;
	
	public void dateProperty() throws IOException  {
		pr = new Properties();
		file  = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Jan10Sele\\src\\datepicker\\data.properties");
		pr.load(file);
	}
	
	public WebDriver init() {
		System.setProperty("webdriver.chrome.driver", pr.getProperty("Chrome"));
		driver = new ChromeDriver();
		return driver;
	}
	
	

}
