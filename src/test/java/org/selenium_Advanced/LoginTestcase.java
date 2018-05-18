package org.selenium_Advanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestcase {
  private WebDriver driver;
	@Test
  public void login() {
		LoginPageObject.uname.sendKeys("selenium");
		LoginPageObject.password.sendKeys("selenium");
		LoginPageObject.login.click();
				  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\A06438_P5.training\\Desktop\\Priyanka\\Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe\\");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		PageFactory.initElements(driver,LoginPageObject.class);
	}

  
  @AfterTest
  public void afterTest() {
  }

}
