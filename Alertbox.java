package alert;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alertbox extends Driver {

	public static void main(String[] args) throws IOException, InterruptedException {
		Driver dr = new Driver();
		dr.alertProp();

		WebDriver driver = dr.init();
		driver.get(pr.getProperty("Url"));
		
		// first box
		driver.findElement(By.xpath(pr.getProperty("aClick"))).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		// second box
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("box2"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("a2"))).click();
		System.out.println(alert.getText());
		alert.dismiss();
		  
		 
		// third box
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("box3"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("a3"))).click();
		alert.sendKeys("sonu");
		alert.accept();

	}

}
