package datepicker.main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import datepicker.DatePick;
import datepicker.DatePickDriver;

public class DatePickers extends DatePickDriver {

	DatePickDriver date;
	WebDriver driver;
	DatePick datePick;

	@Test(priority = 0)
	public void initial() throws Exception {
		date = new DatePickDriver();
		date.dateProperty();
		driver = date.init();
		datePick = new DatePick(driver);
	}

	@Test(dependsOnMethods = {"initial"})
	public void urlFire() {
		datePick.url();
	}

	@Test(dependsOnMethods = {"urlFire"})
	public void enableDatePicker() {
		
		datePick.datePickerEnabled(pr.getProperty("enableDate"), pr.getProperty("dateValue"));
	}

	@Test(dependsOnMethods = {"enableDatePicker"})
	public void disableDatePicker() throws Exception {
		datePick.datePickerDisabled(pr.getProperty("dateValue"));
	}

}
