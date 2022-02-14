package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "F:\\\\Wipro_10jan\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
		
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("FramesExample");
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		
		WebElement element2 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		
		driver.switchTo().frame(element2);
		WebElement element3 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));

		driver.switchTo().frame(element3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("FramesExample");
		
		driver.switchTo().defaultContent();

	}

}
