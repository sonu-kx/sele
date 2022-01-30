package alert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public static Properties pr;
	FileInputStream file;
	WebDriver driver;
	
	public void alertProp() throws IOException {
		pr = new Properties();
		file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Jan10Sele\\src\\alert\\alert.properties");
		pr.load(file);
	}
	
	public WebDriver init() {
		System.setProperty("webdriver.chrome.driver", pr.getProperty("Chrome"));
		driver = new ChromeDriver();
		return driver;
	}
}
