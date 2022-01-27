package pageModel;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration extends Common {
	
	WebDriver driver;
	public Registration(WebDriver driver) {
		this.driver= driver;
	}
	
	public void launchURL() {
		driver.get(prop.getProperty("regURL"));
	}
	
	public void fullName(String val1, String val2) {
		driver.findElement(By.xpath(val1)).sendKeys(val2);
		//driver.findElement(By.xpath(prop.getProperty("lName"))).sendKeys(prop.getProperty("lNameV"));
	}
	
	public void radio(String val) {
		driver.findElement(By.cssSelector(val)).click();;
	}
	
	public void selectByIndex(int val, String val2) {
		Select select = new Select(driver.findElement(By.id(val2)));
		select.selectByIndex(val);
	}
	
	public void selectByValue(String val1, String val2) {
		Select select= new Select(driver.findElement(By.xpath(val1)));
		select.selectByValue(val2);
	}
	
	public void languageHandlling() {
		driver.findElement(By.id(prop.getProperty("language"))).click();
		List<WebElement> list = driver.findElements(By.xpath(prop.getProperty("lang")));
		Random random = new Random();
		WebElement randomElement = list.get(random.nextInt(list.size()));
		randomElement.click();
	}
	
	public void combo(String val1, String val2, String val3) {
		driver.findElement(By.xpath(val1)).click();
		WebElement element= driver.findElement(By.xpath(val2));
		element.sendKeys(val3);
		element.sendKeys(Keys.ENTER);
		
	}
	
	public void tearDown() {
		driver.close();
	}
	

}
