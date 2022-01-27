package param;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ParamReg {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties pr = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\Assign10jan\\src\\property\\inputData.properties");
		pr.load(file);

		System.setProperty("webdriver.chrome.driver", pr.getProperty("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();

		driver.get(pr.getProperty("regURL"));

		driver.findElement(By.xpath(pr.getProperty("fName"))).sendKeys(pr.getProperty("fNameV"));
		driver.findElement(By.xpath(pr.getProperty("lName"))).sendKeys(pr.getProperty("lNameV"));

		// address
		driver.findElement(By.tagName(pr.getProperty("address"))).sendKeys(pr.getProperty("addressV"));

		// email
		driver.findElement(By.xpath(pr.getProperty("email"))).sendKeys(pr.getProperty("emailV"));

		// phone
		driver.findElement(By.cssSelector(pr.getProperty("phone"))).sendKeys(pr.getProperty("phoneV"));

		// gender
		driver.findElement(By.cssSelector(pr.getProperty("genderF"))).click();

		// hobby
		driver.findElement(By.cssSelector(pr.getProperty("hobbyCricket"))).click();
		driver.findElement(By.cssSelector(pr.getProperty("hobbyMovies"))).click();
		driver.findElement(By.cssSelector(pr.getProperty("hobbyHockey"))).click();

		// Language
		driver.findElement(By.id(pr.getProperty("language"))).click();
		List<WebElement> list = driver.findElements(By.xpath(pr.getProperty("lang")));
		Random rand = new Random();
		WebElement randomElement = list.get(rand.nextInt(list.size()));
		randomElement.click();
		
		//skills
		Select select = new Select(driver.findElement(By.id(pr.getProperty("skill"))));
		select.selectByValue(pr.getProperty("skillId"));

	}

}
