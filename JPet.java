package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JPet {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Wipro_10jan\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		driver.findElement(By.name("username")).sendKeys("sample");
		
	}
}
