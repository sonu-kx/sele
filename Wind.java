package window;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wind {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\\\Wipro_10jan\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");

		/*
		 * // first window
		 * driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		 * 
		 * // sencond window
		 * driver.findElement(By.xpath("//a[@href='#Seperate']")).click();
		 * Thread.sleep(1000);
		 * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		 */
		//Multiple window
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='multiwindow()']")).click();

		String parent = driver.getWindowHandle();
		System.out.println(parent);

		Set<String> child = driver.getWindowHandles();
		System.out.println(child);

		Iterator<String> itr = child.iterator();

		while (itr.hasNext()) {

			String childVal = itr.next();

			if (!parent.equals(childVal)) {

				driver.switchTo().window(childVal);
				System.out.println(driver.getTitle());

				if (driver.getTitle().equals("Selenium")) {
					driver.findElement(By.xpath("//a[@href='/downloads']")).click();
					Thread.sleep(2000);
					driver.close();

				} else {
					driver.findElement(By.id("email")).sendKeys("multiple window handle");
					Thread.sleep(2000);
					driver.close();
				}

			}
		}

		
	}

}
