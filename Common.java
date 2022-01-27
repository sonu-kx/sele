package pageModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {
	public static Properties prop;
	FileInputStream file;  
	WebDriver driver;
	
	public void propRead() throws IOException {
		prop = new Properties();
		file= new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Assign10jan\\src\\property\\inputData.properties");
		prop.load(file);
	}
	
	public WebDriver init() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverPath"));
		driver = new ChromeDriver();
		return driver;
	}

}
