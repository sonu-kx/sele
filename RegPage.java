package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageModel.Common;
import pageModel.Registration;

public class RegPage extends Common {
	
	Common com;
	WebDriver driver;
	Registration reg;
	
	
	@BeforeMethod
	public void initial() throws Exception {
		com = new Common();
		com.propRead();
		driver = com.init();
		driver.manage().window().maximize();
		reg = new Registration(driver);
		reg.launchURL();
	}
	
	@Test
	public void register1() throws Exception {
		
		
		//fullname
		reg.fullName(prop.getProperty("fName"), prop.getProperty("fNameV"));
		reg.fullName(prop.getProperty("lName"), prop.getProperty("lNameV"));
		
		//address
		reg.fullName(prop.getProperty("address"), prop.getProperty("addressV"));
		
		//Emain
		reg.fullName(prop.getProperty("email"), prop.getProperty("emailV"));
		
		//phone
		reg.fullName(prop.getProperty("phone"), prop.getProperty("phoneV"));
		
		//gender
		reg.radio(prop.getProperty("genderM"));
		
		//hobby
		reg.radio(prop.getProperty("hobbyCricket"));
		reg.radio(prop.getProperty("hobbyHockey"));
		
		//language
		reg.languageHandlling();
		
		//select skill
		reg.selectByIndex(5, prop.getProperty("skill"));
		
		//combobox
		reg.combo(prop.getProperty("comboC"), prop.getProperty("comboT"), prop.getProperty("comboV"));
		
		//DATE
		reg.selectByValue(prop.getProperty("year"), prop.getProperty("yearV"));
		reg.selectByValue(prop.getProperty("month"), prop.getProperty("monthV"));
		reg.selectByIndex(15, prop.getProperty("day"));
		
		//password
		reg.fullName(prop.getProperty("password"), prop.getProperty("passwordV"));
		reg.fullName(prop.getProperty("passwordC"), prop.getProperty("passwordV"));
		
		//submit
		reg.radio(prop.getProperty("submit"));
		
		
	}
	
	@Test
	public void register2() throws Exception {
		
		//fullname
		reg.fullName(prop.getProperty("fName"), prop.getProperty("fNameV2"));
		reg.fullName(prop.getProperty("lName"), prop.getProperty("lNameV2"));
		
		//address
		reg.fullName(prop.getProperty("address"), prop.getProperty("addressV"));
		
		//Emain
		reg.fullName(prop.getProperty("email"), prop.getProperty("emailV"));
		
		//phone
		reg.fullName(prop.getProperty("phone"), prop.getProperty("phoneV"));
		
		//gender
		reg.radio(prop.getProperty("genderM"));
		
		//hobby
		reg.radio(prop.getProperty("hobbyCricket"));
		reg.radio(prop.getProperty("hobbyHockey"));
		
		//language
		reg.languageHandlling();
		
		//select skill
		reg.selectByIndex(5, prop.getProperty("skill"));
		
		//combobox
		reg.combo(prop.getProperty("comboC"), prop.getProperty("comboT"), prop.getProperty("comboV"));
		
		//DATE
		reg.selectByValue(prop.getProperty("year"), prop.getProperty("yearV"));
		reg.selectByValue(prop.getProperty("month"), prop.getProperty("monthV"));
		reg.selectByIndex(15, prop.getProperty("day"));
		
		//password
		reg.fullName(prop.getProperty("password"), prop.getProperty("passwordV"));
		reg.fullName(prop.getProperty("passwordC"), prop.getProperty("passwordV"));
		
		//submit
		reg.radio(prop.getProperty("submit"));
		
	}
	
	@AfterMethod
	public void tear() {
		reg.tearDown();
	}


}
