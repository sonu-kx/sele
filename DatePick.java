package datepicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;

public class DatePick extends DatePickDriver {
	
	WebDriver driver;
	Assertion assertion= new Assertion();
	
	public DatePick(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void url() {
		driver.get(pr.getProperty("Url"));
		//assert
		WebElement element=driver.findElement(By.xpath("//div/h1"));
		System.out.println(element.getText());
		assertion.assertTrue(element.getText().equals("Automation Demo Site"));
	}
	
	public void datePickerEnabled(String val1, String val2) {
	
		//assertion
		assertion.assertTrue(driver.findElement(By.xpath("(//label[@class='control-label'])[2]")).getText().equals("DatePicker Enabled"));
		
		WebElement element= driver.findElement(By.id(val1));
		element.sendKeys(val2);
		element.sendKeys(Keys.ENTER);
	}
	
	public void datePickerDisabled(String dateVlaue) throws Exception {
		
		//assert
		assertion.assertTrue(driver.findElement(By.xpath("//label[@class='control-label']")).getText().equals("DatePicker Disabled"));
		
		driver.findElement(By.id(pr.getProperty("disableDate"))).click();
		String date = dateVlaue;
		String[] str = date.split("/");
		boolean flag = true;
		
		while(flag) {
			WebElement year = driver.findElement(By.xpath(pr.getProperty("year")));
			if (Integer.parseInt(str[2]) == Integer.parseInt(year.getText())) {
				//flag = false;
				//boolean flag2 = true;

				while (flag) {

					WebElement month = driver.findElement(By.xpath(pr.getProperty("month")));

					// convert alphabetic month to numerical
					SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
					Calendar cal = Calendar.getInstance();
					cal.setTime(inputFormat.parse(month.getText()));
					SimpleDateFormat outputFormat = new SimpleDateFormat("MM");

					if (Integer.parseInt(str[0]) == Integer.parseInt(outputFormat.format(cal.getTime()))) {
						flag = false;

						List<WebElement> row = driver.findElements(By.xpath(pr.getProperty("rowDate")));
						if (row.size() != 0) {
							for (int i = 0; i < row.size(); i++) { 	//row
								List<WebElement> col = driver.findElements(By.xpath(pr.getProperty("colDate")));

								for (int j = 0; j < col.size(); j++) {	//cell
									WebElement cell = col.get(j);
									
									if (!cell.getText().isBlank())
										//System.out.println(cell.getText());
										if (Integer.parseInt(cell.getText()) == Integer.parseInt(str[1])) {
											cell.click();
											return;
										}
								}
							}
						}

					}

					else if (Integer.parseInt(str[0]) > Integer.parseInt(outputFormat.format(cal.getTime()))) {
						driver.findElement(By.linkText(pr.getProperty("Next"))).click();
					}

					else if (Integer.parseInt(str[0]) < Integer.parseInt(outputFormat.format(cal.getTime()))) {
						driver.findElement(By.linkText(pr.getProperty("Prev"))).click();
					}
				}

			}

			else if (Integer.parseInt(str[2]) > Integer.parseInt(year.getText())) {
				driver.findElement(By.linkText(pr.getProperty("Next"))).click();
			}

			else if (Integer.parseInt(str[2]) < Integer.parseInt(year.getText())) {
				driver.findElement(By.linkText(pr.getProperty("Prev"))).click();
			}
		}
		
		
	}

}
